package cn.com.payu.modules.loans.service;

import cn.com.payu.common.enmus.CallbackType;
import cn.com.payu.common.enmus.DataDictionary;
import cn.com.payu.common.enmus.LoanStatus;
import cn.com.payu.common.utils.idcardUtil.IdcardInfoExtractor;
import cn.com.payu.modules.entity.*;
import cn.com.payu.modules.loans.model.LoansModel;
import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.mapper.*;
import cn.com.payu.modules.model.LoanPlansModel;
import cn.com.payu.modules.model.OrderModel;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.redis.service.GainIdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author payu
 */
@Slf4j
@Service
public class LoansBizService {

    @Autowired
    private LoansApiService loansApiService;

    @Autowired
    private GainIdService gainIdService;

    @Autowired
    private LoanMapper loanMapper;
    @Autowired
    private LoanAddressMapper loanAddressMapper;
    @Autowired
    private LoanContactMapper loanContactMapper;
    @Autowired
    private LoanDocumentMapper loanDocumentMapper;
    @Autowired
    private LoanIncomeMapper loanIncomeMapper;
    @Autowired
    private LoanJobMapper loanJobMapper;
    @Autowired
    private LoanPersonalMapper loanPersonalMapper;
    @Autowired
    private LoanPlansMapper loanPlansMapper;
    @Autowired
    private LoanBankcardMapper loanBankcardMapper;

    public String applymentIndex(ApplymentIndexReq req, String phone) {

        String orderNumber = gainIdService.gainId("B");

        req.setOrderNumber(orderNumber);

        //执行进件
        ApplymentIndexResp resp = loansApiService.applymentIndex(req);

        ApplymentIndexLoan indexLoan = req.getLoanData();
        ApplymentIndexPersonal personal = req.getPersonalData();
        ApplymentIndexAddress address = req.getAddressData();
        List<ApplymentIndexContact> contactData = req.getContactData();
        ApplymentIndexJob job = req.getJobData();
        ApplymentIndexIncome income = req.getIncomeData();
        ApplymentIndexDocument document = req.getDocumentData();

        // 2020/8/10 入库
        Loan loan = new Loan();
        LoanPersonal loanPersonal = new LoanPersonal();
        LoanAddress loanAddress = new LoanAddress();
        LoanJob loanJob = new LoanJob();
        List<LoanIncome> loanIncomeList = new ArrayList<>();
        List<LoanContact> loanContactList = new ArrayList<>();

        BeanUtils.copyProperties(indexLoan, loan);
        BeanUtils.copyProperties(personal, loanPersonal);
        BeanUtils.copyProperties(address, loanAddress);
        BeanUtils.copyProperties(job, loanJob);

        loan.setOrderNumber(orderNumber);
        loan.setLoanStatus(LoanStatus.INIT.getCode());
        loan.setPayMethod(DataDictionary.PayMethod.method2.getCode());
        loanMapper.insertUseGeneratedKeys(loan);

        loanPersonal.setLoanId(loan.getId());
        loanPersonal.setPhoneNumber(phone);
        loanPersonal.setCertificateType(1);
        IdcardInfoExtractor ie = new IdcardInfoExtractor(loanPersonal.getCertificateNumber());
        loanPersonal.setGender(ie.getGender());

        loanAddress.setLoanId(loan.getId());
        loanJob.setLoanId(loan.getId());

        if (income.getPrivateIncome() != null) {
            LoanIncome loanIncome = new LoanIncome();
            BeanUtils.copyProperties(income.getPrivateIncome(), loanIncome);
            loanIncome.setLoanId(loan.getId());
            loanIncomeList.add(loanIncome);
        }
        if (income.getPublicIncome() != null) {
            LoanIncome loanIncome = new LoanIncome();
            BeanUtils.copyProperties(income.getPublicIncome(), loanIncome);
            loanIncome.setLoanId(loan.getId());
            loanIncomeList.add(loanIncome);
        }
        List<LoanDocument> loanDocumentList = transDocument(loan.getId(), document);
        for (ApplymentIndexContact indexContact : contactData) {
            LoanContact loanContact = new LoanContact();
            BeanUtils.copyProperties(indexContact, loanContact);
            loanContact.setLoanId(loan.getId());
            loanContactList.add(loanContact);
        }
        loanPersonalMapper.insert(loanPersonal);
        loanAddressMapper.insert(loanAddress);
        loanJobMapper.insert(loanJob);
        loanDocumentMapper.insertList(loanDocumentList);
        loanIncomeMapper.insertList(loanIncomeList);
        loanContactMapper.insertList(loanContactList);

        return orderNumber;
    }

    public List<LoanDocument> transDocument(Long loanId, ApplymentIndexDocument aiDocument) {
        List<LoanDocument> loanDocumentList = new ArrayList();

        LoanDocument document1 = new LoanDocument();
        document1.setLoanId(loanId);
        document1.setType(DataDictionary.DocumentFile.id_card_front.getCode());
        document1.setName(DataDictionary.DocumentFile.id_card_front.getValue());
        document1.setUrl(aiDocument.getIdCardFront());
        loanDocumentList.add(document1);

        LoanDocument document2 = new LoanDocument();
        document2.setLoanId(loanId);
        document2.setType(DataDictionary.DocumentFile.id_card_back.getCode());
        document2.setName(DataDictionary.DocumentFile.id_card_back.getValue());
        document2.setUrl(aiDocument.getIdCardFront());
        loanDocumentList.add(document2);

        String[] creditReport = aiDocument.getCreditReport();
        if (creditReport != null) {
            for (String url : creditReport) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.credit_report.getCode());
                document.setName(DataDictionary.DocumentFile.credit_report.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        String[] incomeProof = aiDocument.getIncomeProof();
        if (incomeProof != null) {
            for (String url : incomeProof) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.income_proof.getCode());
                document.setName(DataDictionary.DocumentFile.income_proof.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        String[] addressProof = aiDocument.getAddressProof();
        if (addressProof != null) {
            for (String url : addressProof) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.address_proof.getCode());
                document.setName(DataDictionary.DocumentFile.address_proof.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        String[] assistMaterial = aiDocument.getAssistMaterial();
        if (assistMaterial != null) {
            for (String url : assistMaterial) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.assist_material.getCode());
                document.setName(DataDictionary.DocumentFile.assist_material.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        String[] applyMaterial = aiDocument.getApplyMaterial();
        if (applyMaterial != null) {
            for (String url : applyMaterial) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.apply_material.getCode());
                document.setName(DataDictionary.DocumentFile.apply_material.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        String[] signVideo = aiDocument.getSignVideo();
        if (signVideo != null) {
            for (String url : signVideo) {
                LoanDocument document = new LoanDocument();
                document.setLoanId(loanId);
                document.setType(DataDictionary.DocumentFile.sign_video.getCode());
                document.setName(DataDictionary.DocumentFile.sign_video.getValue());
                document.setUrl(url);
                loanDocumentList.add(document);
            }
        }
        return loanDocumentList;
    }

    public void applymentReject(ApplymentRejectReq req) {
        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        req.setOrderNumber(loan.getApplyNumber());
        ApplymentRejectResp resp = loansApiService.applymentReject(req);

        loan.setLoanPeriod(req.getLoanPeriod());
        loan.setAnnuity(req.getAnnuity());
        loanMapper.updateByPrimaryKeySelective(loan);
    }

    public ApplymentGetSignStateRespData applymentGetSignState(String orderNumber) {
        ApplymentGetSignStateReq req = new ApplymentGetSignStateReq();
        req.setOrderNumber(orderNumber);
        ApplymentGetSignStateResp resp = loansApiService.applymentGetSignState(req);
        return resp.getData();
    }

    public ApplymentQueryOrderRespData applymentQueryOrder(String orderNumber) {
        ApplymentQueryOrderReq req = new ApplymentQueryOrderReq();
        req.setOrderNumber(orderNumber);
        ApplymentQueryOrderResp resp = loansApiService.applymentQueryOrder(req);
        return resp.getData();
    }

    public List<ApplymentQueryPlansItem> applymentQueryPlans(String orderNumber) {
        Loan loan = loanMapper.selectByOrderNumber(orderNumber);

        ApplymentQueryPlansReq req = new ApplymentQueryPlansReq();
        req.setOrderNumber(loan.getApplyNumber());
        ApplymentQueryPlansResp resp = loansApiService.applymentQueryplans(req);
        if (!CollectionUtils.isEmpty(resp.getData().getPlanList())) {
            return resp.getData().getPlanList().get(0);
        }
        return null;
    }

    public List<PayGetBanklistItem> payGetbanklist() {
        PayGetBanklistResp resp = loansApiService.payGetbanklist(new PayGetBanklistReq());
        return resp.getData();
    }

    public void payPretiedcard(PayPretiedcardReq req) {

        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        //2020/8/14 银行卡信息校验及入库
//        LoanBankcard bankcard = loanBankcardMapper.selectBy4Element(req.getAccountName(), req.getIdcardNo(), req.getAccountNo(), req.getMobile());
        LoanBankcard bankcard = loanBankcardMapper.selectByLoanId(loan.getId());
        if (bankcard != null && DataDictionary.BindStatus.bound.getCode().equals(bankcard.getBindStatus()))
            throw BusinessException.create("该银行卡已经绑卡，请勿重复绑卡！");

        req.setOrderNumber(loan.getApplyNumber());
        PayPretiedcardResp resp = loansApiService.payPretiedcard(req);
        PayPretiedcardRespData respData = resp.getData();

        if (bankcard == null) bankcard = new LoanBankcard();
        bankcard.setLoanId(loan.getId());
        bankcard.setAccountName(req.getAccountName());
        bankcard.setIdcardNo(req.getIdcardNo());
        bankcard.setAccountNo(req.getAccountNo());
        bankcard.setMobile(req.getMobile());
        bankcard.setUniqueCode(respData.getUniqueCode());
        bankcard.setBindStatus(DataDictionary.BindStatus.unbound.getCode());
        bankcard.setUseStatus(0);
        loanBankcardMapper.insert(bankcard);
    }

    public void payConfirmbindcard(PayConfirmbindcardReq req) {
        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());
        req.setOrderNumber(loan.getApplyNumber());
        PayConfirmbindcardResp resp = loansApiService.payConfirmbindcard(req);

        //2020/8/14 银行卡信息更新：绑定状态、使用状态
        LoanBankcard bankcard = loanBankcardMapper.selectByLoanId(loan.getId());
        bankcard.setUniqueCode(req.getUniqueCode());
        bankcard.setBindStatus(DataDictionary.BindStatus.bound.getCode());
        bankcard.setUseStatus(1);
        loanBankcardMapper.updateByPrimaryKeySelective(bankcard);
    }

    public PayQueryWithholdResp payQuerywithhold(String tradeNumber) {
        PayQueryWithholdReq req = new PayQueryWithholdReq();
        req.setTradeNumber(tradeNumber);
        PayQueryWithholdResp resp = loansApiService.payQuerywithhold(req);
        return resp;
    }

    public PayGetPayInfoRespData payGetPayInfo(String orderNumber, String repayType) {
        PayGetPayInfoReq req = new PayGetPayInfoReq();
        req.setOrderNumber(orderNumber);
        req.setRepayType(repayType);
        PayGetPayInfoResp resp = loansApiService.payGetPayInfo(req);
        return resp.getData();
    }

    public EsignSigncontractRespData esignSigncontract(String orderNumber, String noticeType) {
        Loan loan = loanMapper.selectByOrderNumber(orderNumber);

        EsignSigncontractReq req = new EsignSigncontractReq();
        req.setOrderNumber(loan.getApplyNumber());
        req.setNoticeType(noticeType);
        EsignSigncontractResp resp = loansApiService.esignSigncontract(req);
        return resp.getData();
    }

    public EsignMycontractRespData esignMycontract(String orderNumber) {
        Loan loan = loanMapper.selectByOrderNumber(orderNumber);

        EsignMycontractReq req = new EsignMycontractReq();
        req.setOrderNumber(loan.getApplyNumber());
        EsignMycontractResp resp = loansApiService.esignMycontract(req);
        return resp.getData();
    }

    public EsignGetSignUrlRespData esignGetSignUrl(String orderNumber, Integer signType) {
        EsignGetSignUrlReq req = new EsignGetSignUrlReq();
        req.setOrderNumber(orderNumber);
        req.setSignType(signType);
        EsignGetSignUrlResp resp = loansApiService.esignGetSignUrl(req);
        return resp.getData();
    }

    public List<BasicsGetLoansProductsItem> basicsGetLoansProducts() {
        BasicsGetLoansProductsResp resp = loansApiService.basicsGetLoansProducts(new BasicsGetLoansProductsReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetLoansPeriods() {
        BasicsGetLoansPeriodsResp resp = loansApiService.basicsGetLoansPeriods(new BasicsGetLoansPeriodsReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetHousingTypes() {
        BasicsGetHousingTypesResp resp = loansApiService.basicsGetHousingTypes(new BasicsGetHousingTypesReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetTogetherDwellList() {
        BasicsGetTogetherDwellListResp resp = loansApiService.basicsGetTogetherDwellList(new BasicsGetTogetherDwellListReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetRelationTypelList() {
        BasicsGetRelationTypelListResp resp = loansApiService.basicsGetRelationTypelList(new BasicsGetRelationTypelListReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetLoanPurposeList() {
        BasicsGetLoanPurposeListResp resp = loansApiService.basicsGetLoanPurposeList(new BasicsGetLoanPurposeListReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetEducationList() {
        BasicsGetEducationListResp resp = loansApiService.basicsGetEducationList(new BasicsGetEducationListReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetMarriageList() {
        BasicsGetMarriageListResp resp = loansApiService.basicsGetMarriageList(new BasicsGetMarriageListReq());
        return resp.getData();
    }

    public Map<String, String> basicsGetUnitTypeList() {
        BasicsGetUnitTypeListResp resp = loansApiService.basicsGetUnitTypeList(new BasicsGetUnitTypeListReq());
        return resp.getData();
    }

    public List<BasicsGetIndustryTypeListItem> basicsGetIndustryTypeList(Integer pid) {
        BasicsGetIndustryTypeListReq req = new BasicsGetIndustryTypeListReq();
        req.setPid(pid);
        BasicsGetIndustryTypeListResp resp = loansApiService.basicsGetIndustryTypeList(req);
        return resp.getData();
    }

    public int applymentCallback(ApplymentIndexCallbackReq req) {

        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        if (loan == null) {
            log.warn("进件订单{}不存在", req.getOrderNumber());
            return 1;
        }

        log.warn("订单{}回调{}", req.getOrderNumber(), req.getDescription());
        if (CallbackType.APPLY_DATA_CHECK.getCode().equals(req.getCallbackType())) {

        } else if (CallbackType.APPLY_SUCCESS.getCode().equals(req.getCallbackType())) {
            loan.setApplyNumber(req.getApplyNumber());//对方订单编号
            loan.setAuditAmount(req.getAuditAmount());//审核额度
            loan.setAuditPeriod(req.getAuditPeriod());//审核期数
            loan.setLoanStatus(LoanStatus.RC_FIRST_TRIAL.getCode());
        } else if (CallbackType.RC_PASS.getCode().equals(req.getCallbackType())) {//对方初审通过不会回调，复审通过才会回调
//            if (LoanStatus.RC_FIRST_TRIAL.getCode().equals(loan.getLoanStatus())) {//初审通过
//                loan.setLoanStatus(LoanStatus.RC_RETRIAL.getCode());
//            } else {//复审通过
//                loan.setLoanStatus(LoanStatus.WAITING_SIGN.getCode());
//            }

            loan.setLoanStatus(LoanStatus.WAITING_SIGN.getCode());
        } else if (CallbackType.RC_REFUSE.getCode().equals(req.getCallbackType())) {
            loan.setLoanStatus(LoanStatus.UNPASS.getCode());
        } else if (CallbackType.SIGNED.getCode().equals(req.getCallbackType())) {
            loan.setLoanStatus(LoanStatus.WAITING_LOAN.getCode());
        } else if (CallbackType.LOANED.getCode().equals(req.getCallbackType())) {
            if (LoanStatus.REPAYING.getCode().equals(loan.getLoanStatus())) {
                log.warn("订单{}重复放款回调，忽略处理请求", req.getOrderNumber());
                return 1;
            }

            // 查询并生成还款计划
            generatePlans(loan.getId(), req.getOrderNumber());

            loan.setLoanStatus(LoanStatus.REPAYING.getCode());
        } else if (CallbackType.SETTLED.getCode().equals(req.getCallbackType())) {
            loan.setLoanStatus(LoanStatus.SETTLED.getCode());
        } else if (CallbackType.REFUSE_LOAN.getCode().equals(req.getCallbackType())) {
            loan.setLoanStatus(LoanStatus.REFUSE_LOAN.getCode());
        } else if (CallbackType.VOLUNTARY_REPAYMENT.getCode().equals(req.getCallbackType())) {
            // TODO: 2020/8/10 修改还款计划还款状态
        }

        loanMapper.updateByPrimaryKeySelective(loan);

        return 0;
    }

    /**
     * 生成还款计划表
     *
     * @param id
     * @param orderNumber
     */
    public void generatePlans(Long id, String orderNumber) {
        List<ApplymentQueryPlansItem> planList = this.applymentQueryPlans(orderNumber);
        if (!CollectionUtils.isEmpty(planList)) {
            List<LoanPlans> loanPlans = new ArrayList<>();
            for (ApplymentQueryPlansItem item : planList) {
                LoanPlans plans = new LoanPlans();
                BeanUtils.copyProperties(item, plans);
                plans.setLoanId(id);
                plans.setOuterId(item.getId());
                loanPlans.add(plans);
            }
            loanPlansMapper.insertList(loanPlans);
        }
    }

    public LoansModel getCurrentLoanDetails(String phone) {

        OrderModel om = loanMapper.selectLastLoanByCustomerPhone(phone);

        LoansModel model = new LoansModel();
        if (om != null) {
            model.setOrderNumber(om.getOrderNumber());
            model.setName(om.getName());
            model.setIdcardNo(om.getCertificateNumber());
            model.setPhoneNumber(om.getPhoneNumber());
            model.setAnnuity(om.getAuditAmount() == null ? om.getAnnuity() : om.getAuditAmount());
            model.setLoanPeriod(om.getAuditPeriod() == null ? om.getLoanPeriod() : om.getAuditPeriod());
            model.setLoanStatus(om.getLoanStatus());
            model.setLoanStatusDesc(LoanStatus.getNameByCode(om.getLoanStatus()));
            model.setBindStatus(om.getBindStatus());

            if (om.getBindStatus() == null) model.setBindStatus(DataDictionary.BindStatus.unbound.getCode());
            model.setBindStatusDesc(DataDictionary.BindStatus.getValueByCode(om.getBindStatus()));
        }
        return model;
    }

    public Integer getRepayStatus(Long loanId) {
        List<LoanPlansModel> plansList = loanPlansMapper.selectDetailsByLoanId(loanId);
        if (CollectionUtils.isEmpty(plansList)) return DataDictionary.RepayStatus.initialize.getCode();
        boolean overdueFlag = false;
        boolean repaymentFlag = true;
        for (LoanPlansModel lpm : plansList) {
            if (DataDictionary.RepayStatus.unrepayment.getCode().equals(lpm.getPlanStatus()) && lpm.getOverdueDays() > 0) {
                overdueFlag = true;
            }
            if (!DataDictionary.RepayStatus.repayment.getCode().equals(lpm.getPlanStatus())) {
                repaymentFlag = false;
            }
        }
        if (overdueFlag) return DataDictionary.RepayStatus.overdue.getCode();
        if (repaymentFlag) return DataDictionary.RepayStatus.repayment.getCode();
        return DataDictionary.RepayStatus.unrepayment.getCode();
    }

}
