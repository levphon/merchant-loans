package cn.com.payu.modules.loans.service;

import cn.com.payu.common.enmus.CallbackType;
import cn.com.payu.common.enmus.DataDictionary;
import cn.com.payu.common.enmus.LoanStatus;
import cn.com.payu.common.utils.idcardUtil.IdcardInfoExtractor;
import cn.com.payu.modules.entity.*;
import cn.com.payu.modules.loans.model.*;
import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.mapper.*;
import cn.com.payu.modules.model.LoanPlansModel;
import cn.com.payu.modules.model.OrderModel;
import com.alibaba.excel.util.StringUtils;
import com.glsx.plat.common.utils.DateUtils;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.redis.service.GainIdService;
import com.glsx.plat.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

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
    private RedisUtils redisUtils;

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

    @Autowired
    private LoanEsignMapper loanEsignMapper;

    public String applymentIndex(ApplymentIndexReq req, String phone) {

        String orderNumber = gainIdService.gainId("B");

        req.setOrderNumber(orderNumber);

        IdcardInfoExtractor ie = new IdcardInfoExtractor(req.getPersonalData().getCertificateNumber());
        req.getPersonalData().setGender(ie.getGender());

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
        loanBankcardMapper.insertOrUpdate(bankcard);
    }

    public void payConfirmbindcard(PayConfirmbindcardReq req) {
        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());
        LoanBankcard bankcard = loanBankcardMapper.selectByLoanId(loan.getId());

        req.setOrderNumber(loan.getApplyNumber());
        req.setUniqueCode(bankcard.getUniqueCode());
        PayConfirmbindcardResp resp = loansApiService.payConfirmbindcard(req);

        //2020/8/14 银行卡信息更新：绑定状态、使用状态
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

    public PreSigncontractModel preSigncontract(String orderNumber) {
        Loan loan = loanMapper.selectByOrderNumber(orderNumber);
        LoanBankcard loanBankcard = loanBankcardMapper.selectByLoanId(loan.getId());

        PreSigncontractModel model = new PreSigncontractModel();
        model.setAccountName(loanBankcard.getAccountName());
        model.setIdcardNo(loanBankcard.getIdcardNo());
        model.setAccountNo(loanBankcard.getAccountNo());
        model.setMobile(loanBankcard.getMobile());
        model.setAnnuity(loan.getAnnuity());
        model.setApplyTime(loan.getCreatedDate());
        return model;
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

        EsignGetSignUrlRespData respData = resp.getData();

        Loan loan = loanMapper.selectByOrderNumber(orderNumber);
        LoanEsign esign = loanEsignMapper.selectByLoanIdAndSignType(loan.getId(), signType);
        if (esign == null) esign = new LoanEsign();
        esign.setLoanId(loan.getId());
        esign.setUrl(respData.getUrl());
        esign.setShortUrl(respData.getShortUrl());
        esign.setSignType(signType);
        loanEsignMapper.insertOrUpdate(esign);

        return respData;
    }

    public List<BasicsGetLoansProductsItem> basicsGetLoansProducts() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        List<BasicsGetLoansProductsItem> itemList = redisUtils.lGet(key);
        if (!CollectionUtils.isEmpty(itemList)) return itemList;

        BasicsGetLoansProductsResp resp = loansApiService.basicsGetLoansProducts(new BasicsGetLoansProductsReq());
        itemList = resp.getData();
        redisUtils.lSet(key, itemList);
        return itemList;
    }

    public Map<String, String> basicsGetLoansPeriods() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetLoansPeriodsResp resp = loansApiService.basicsGetLoansPeriods(new BasicsGetLoansPeriodsReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetHousingTypes() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetHousingTypesResp resp = loansApiService.basicsGetHousingTypes(new BasicsGetHousingTypesReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetTogetherDwellList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetTogetherDwellListResp resp = loansApiService.basicsGetTogetherDwellList(new BasicsGetTogetherDwellListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetRelationTypelList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetRelationTypelListResp resp = loansApiService.basicsGetRelationTypelList(new BasicsGetRelationTypelListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetLoanPurposeList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetLoanPurposeListResp resp = loansApiService.basicsGetLoanPurposeList(new BasicsGetLoanPurposeListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetEducationList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetEducationListResp resp = loansApiService.basicsGetEducationList(new BasicsGetEducationListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetMarriageList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetMarriageListResp resp = loansApiService.basicsGetMarriageList(new BasicsGetMarriageListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
    }

    public Map<String, String> basicsGetUnitTypeList() {
        String key = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, String> stringMap = redisUtils.hmgetT(key);
        if (!CollectionUtils.isEmpty(stringMap)) return stringMap;

        BasicsGetUnitTypeListResp resp = loansApiService.basicsGetUnitTypeList(new BasicsGetUnitTypeListReq());
        stringMap = resp.getData();
        redisUtils.hmsetT(key, stringMap);
        return stringMap;
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
        if (!CallbackType.APPLY_DATA_CHECK.getCode().equals(req.getCallbackType())) {
            if (StringUtils.isEmpty(req.getApplyNumber())) throw BusinessException.create(400, "ApplyNumber不能为空");
        }

        log.warn("订单{}回调{}", req.getOrderNumber(), req.getDescription());
        if (CallbackType.APPLY_DATA_CHECK.getCode().equals(req.getCallbackType())) {
            loan.setLoanStatus(LoanStatus.UNPASS.getCode());
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
            // 2020/8/10 修改还款计划还款状态
            LoanPlans plans = loanPlansMapper.selectByLoanIdAndPeriods(loan.getId(), req.getPeriodOrder());
            if (plans == null) {
                log.warn("订单{}第{}还款计划不存在", req.getOrderNumber(), req.getPeriodOrder());
                return 1;
            }
            if (req.getIsFinish()) {
                plans.setPlanStatus(DataDictionary.PlansRepayStatus.repayment.getCode());
                plans.setRepaidTime(new Date());
                plans.setUpdatedDate(plans.getRepaidTime());
                loanPlansMapper.updateByPrimaryKeySelective(plans);
                return 0;
            }
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

            //如果授权书或合同没签署，则去查询最新签署状态
            if (!DataDictionary.SignStatus.finished.getCode().equals(om.getProtocolStatus())
                    || !DataDictionary.SignStatus.finished.getCode().equals(om.getContractStatus())) {
                ApplymentGetSignStateRespData signStateRespData = this.applymentGetSignState(om.getOrderNumber());
                if (signStateRespData != null) {
                    model.setProtocolStatus(signStateRespData.getProtocolStatus());
                    model.setProtocolMsg(signStateRespData.getProtocolMsg());
                    model.setContractStatus(signStateRespData.getContractStatus());
                    model.setContractMsg(signStateRespData.getContractMsg());

                    //更新签署状态
                    Loan loan = loanMapper.selectByPrimaryKey(om.getId());
                    loan.setProtocolStatus(signStateRespData.getProtocolStatus());
                    loan.setContractStatus(signStateRespData.getContractStatus());
                    loanMapper.updateByPrimaryKeySelective(loan);
                } else {
                    model.setProtocolMsg("--");
                    model.setContractMsg("--");
                }
            } else {
                model.setProtocolStatus(om.getProtocolStatus());
                model.setProtocolMsg(DataDictionary.SignStatus.getValueByCode(om.getProtocolStatus()));
                model.setContractStatus(om.getContractStatus());
                model.setContractMsg(DataDictionary.SignStatus.getValueByCode(om.getContractStatus()));
            }
            if (om.getBindStatus() == null) model.setBindStatus(DataDictionary.BindStatus.unbound.getCode());
            model.setBindStatusDesc(DataDictionary.BindStatus.getValueByCode(om.getBindStatus()));
        }
        return model;
    }

    public Integer getRepayStatus(Long loanId) {

        LoanRecordDetails details = getLoanRecordDetails(loanId);

        if (CollectionUtils.isEmpty(details.getPlans())) return DataDictionary.LoanRepayStatus.initialize.getCode();

        return details.getRepayStatus();
    }

    /**
     * 获取借款详情
     *
     * @param loanId
     * @return
     */
    public LoanRecordDetails getLoanRecordDetails(Long loanId) {
        Loan loan = loanMapper.selectByPrimaryKey(loanId);

        LoanRecordDetails details = new LoanRecordDetails();

        int repaymentCnt = 0;
        int overdueCnt = 0;
        Integer currentPeriod = 0;//本期期数
        BigDecimal currentPeriodRepayMoney = BigDecimal.ZERO;//本期应还金额
        BigDecimal currentPeriodPrincipal = BigDecimal.ZERO;//本期本金
        Date currentPeriodRepayDate = null;
        BigDecimal currentRepayTotalMoney = BigDecimal.ZERO;//逾期未还的+当期的未还
        BigDecimal currentRepayTotalPrincipal = BigDecimal.ZERO;//逾期未还本金+当期的未还本金
        BigDecimal totalRemainPrincipal = BigDecimal.ZERO;//总的剩余本金
        BigDecimal totalRemainRepayAmount = BigDecimal.ZERO;//总的剩余要还

        details.setRepayStatus(DataDictionary.LoanRepayStatus.normal.getCode());

        List<LoanPlansModel> plansList = loanPlansMapper.selectDetailsByLoanId(loan.getId());
        if (!CollectionUtils.isEmpty(plansList)) {

            Date curr = DateUtils.truncate(new Date(), Calendar.DATE);

            for (LoanPlansModel lpm : plansList) {

                Date next = lpm.getPlanRepayTime();

                if (DataDictionary.PlansRepayStatus.repayment.getCode().equals(lpm.getPlanStatus())) {
                    repaymentCnt++;
                }
                if (DataDictionary.PlansRepayStatus.unrepayment.getCode().equals(lpm.getPlanStatus())) {

                    totalRemainPrincipal = totalRemainPrincipal.add(lpm.getPlanRepayPrincipal());

                    totalRemainRepayAmount = totalRemainRepayAmount.add(lpm.getPlanRepayTotal());

                    currentRepayTotalMoney = currentRepayTotalMoney.add(lpm.getPlanRepayTotal());
                    currentRepayTotalPrincipal = currentRepayTotalPrincipal.add(lpm.getPlanRepayPrincipal());
                    //还款时间当前时间
                    if (next.after(curr) || next.equals(curr)) {
                        if (currentPeriodRepayDate == null) {
                            currentPeriodRepayDate = next;
                            currentPeriod = lpm.getPlanPeriodsOrder();
                            currentPeriodRepayMoney = lpm.getPlanRepayTotal();
                            currentPeriodPrincipal = lpm.getPlanRepayPrincipal();
                        } else {
                            //减去多加金额
                            currentRepayTotalMoney = currentRepayTotalMoney.subtract(lpm.getPlanRepayTotal());
                            currentRepayTotalPrincipal = currentRepayTotalPrincipal.subtract(lpm.getPlanRepayPrincipal());
                        }
                    }
                }
                if (DataDictionary.PlansRepayStatus.unrepayment.getCode().equals(lpm.getPlanStatus()) && lpm.getOverdueDays() > 0) {
                    overdueCnt++;

                    lpm.setPlanStatus(DataDictionary.PlansRepayStatus.overdue.getCode());
                }
                lpm.setPlanStatusDesc(DataDictionary.PlansRepayStatus.getValueByCode(lpm.getPlanStatus()));
            }
        }

        details.setLoanId(loan.getId());
        details.setOrderNumber(loan.getOrderNumber());
        details.setAnnuity(loan.getAuditAmount() == null ? loan.getAnnuity() : loan.getAuditAmount());
        details.setLoanPeriod(loan.getAuditPeriod() == null ? loan.getLoanPeriod() : loan.getAuditPeriod());
        details.setLoanDate(loan.getCreatedDate());

        details.setRepaidPeriod(repaymentCnt);
        details.setOverduePeriod(overdueCnt);

        details.setPlans(plansList);

        //逾期
        if (overdueCnt > 0)
            details.setRepayStatus(DataDictionary.LoanRepayStatus.overdue.getCode());
        //结清
        if (LoanStatus.SETTLED.getCode().equals(loan.getLoanStatus()))
            details.setRepayStatus(DataDictionary.LoanRepayStatus.settled.getCode());

        //当期
        details.setCurrentPeriod(currentPeriod);
        details.setCurrentPeriodRepayMoney(currentPeriodRepayMoney);
        details.setCurrentPeriodPrincipal(currentPeriodPrincipal);
        details.setCurrentPeriodRepayDate(currentPeriodRepayDate);
        //当期+逾期
        details.setCurrentRepayTotalMoney(currentRepayTotalMoney);
        details.setCurrentRepayTotalPrincipal(currentRepayTotalPrincipal);
        //剩余
        details.setTotalRemainPrincipal(totalRemainPrincipal);
        details.setTotalRemainRepayAmount(totalRemainRepayAmount);
        return details;
    }

    public List<LoanRecordModel> loanList(String phone) {
        List<LoanRecordModel> list = new ArrayList<>();

        List<Loan> loanList = loanMapper.selectLoanedByCustomerPhone(phone);
        for (Loan loan : loanList) {
            LoanRecordModel lrm = new LoanRecordModel();
            lrm.setLoanId(loan.getId());
            lrm.setOrderNumber(loan.getOrderNumber());
            lrm.setAnnuity(loan.getAuditAmount());
            lrm.setLoanPeriod(loan.getAuditPeriod());
            lrm.setLoanDate(loan.getCreatedDate());

            setLoanRecordModel(lrm);

            list.add(lrm);
        }
        return list;
    }

    private void setLoanRecordModel(LoanRecordModel lrm) {

        LoanRecordDetails details = getLoanRecordDetails(lrm.getLoanId());

        if (CollectionUtils.isEmpty(details.getPlans())) return;

        lrm.setCurrentPeriod(details.getCurrentPeriod());
        lrm.setCurrentPeriodRepayMoney(details.getCurrentPeriodRepayMoney());
        lrm.setCurrentPeriodRepayDate(details.getCurrentPeriodRepayDate());

        lrm.setCurrentRepayTotalMoney(details.getCurrentRepayTotalMoney());
        lrm.setTotalRemainRepayAmount(details.getTotalRemainRepayAmount());

        lrm.setRepayStatus(details.getRepayStatus());
        lrm.setRepayStatusDesc(DataDictionary.LoanRepayStatus.getValueByCode(lrm.getRepayStatus()));

    }

    public LoanRecordDetails loanListDetails(Long loanId) {
        return getLoanRecordDetails(loanId);
    }

    public List<RepayIn7DaysModel> repayIn7days(String phone) {
        List<RepayIn7DaysModel> list = new ArrayList<>();

        List<Loan> loanList = loanMapper.selectLoanedByCustomerPhone(phone);
        for (Loan loan : loanList) {
            LoanRecordDetails details = getLoanRecordDetails(loan.getId());

            RepayIn7DaysModel r7m = new RepayIn7DaysModel();
            r7m.setLoanId(loan.getId());
            r7m.setAnnuity(details.getAnnuity());
            r7m.setLoanPeriod(details.getLoanPeriod());
            r7m.setCurrentPeriod(details.getCurrentPeriod());
            r7m.setCurrentPeriodRepayMoney(details.getCurrentPeriodRepayMoney());
            r7m.setCurrentPeriodRepayDate(details.getCurrentPeriodRepayDate());

            r7m.setCurrentRepayTotalMoney(details.getCurrentRepayTotalMoney());
            r7m.setTotalRemainRepayAmount(details.getTotalRemainRepayAmount());

            r7m.setRepayStatus(details.getRepayStatus());
            r7m.setRepayStatusDesc(DataDictionary.LoanRepayStatus.getValueByCode(r7m.getRepayStatus()));

            boolean plansIn7DaysFlag = false;
            List<LoanPlansModel> plans = details.getPlans();
            if (!CollectionUtils.isEmpty(plans)) {
                for (LoanPlansModel lpm : plans) {
                    if ((-lpm.getOverdueDays()) <= 7) {
                        plansIn7DaysFlag = true;
                        break;
                    }
                }
            }
            if (plansIn7DaysFlag) list.add(r7m);
        }
        return list;
    }

    public RepayIn7DayDetails repayIn7daysDetails(Long loanId) {
        LoanRecordDetails loanRecordDetails = getLoanRecordDetails(loanId);

        RepayIn7DayDetails details = new RepayIn7DayDetails();
        details.setOrderNumber(loanRecordDetails.getOrderNumber());
        details.setLoanPeriod(loanRecordDetails.getLoanPeriod());
        details.setAnnuity(loanRecordDetails.getAnnuity());
        details.setLoanDate(loanRecordDetails.getLoanDate());
        //剩余
        details.setTotalRemainPrincipal(loanRecordDetails.getTotalRemainPrincipal());
        details.setTotalRemainRepayAmount(loanRecordDetails.getTotalRemainRepayAmount());
        //7天待还
        List<LoanPlansModel> plansIn7Days = new ArrayList<>();
        List<LoanPlansModel> plans = loanRecordDetails.getPlans();
        if (!CollectionUtils.isEmpty(plans)) {
            for (LoanPlansModel lpm : plans) {
                if ((-lpm.getOverdueDays()) <= 7) {
                    plansIn7Days.add(lpm);
                }
            }
        }
        details.setPlans(plansIn7Days);
        return details;
    }

}
