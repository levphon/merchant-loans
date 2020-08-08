package cn.com.payu.modules.loans.service;

import cn.com.payu.modules.entity.Loan;
import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.mapper.LoanMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private LoanMapper loanMapper;

    public void applymentIndex(ApplymentIndexReq req) {
        ApplymentIndexResp resp = loansApiService.applymentIndex(req);
    }

    public void applymentReject(ApplymentRejectReq req) {
        ApplymentRejectResp resp = loansApiService.applymentReject(req);
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

    public ApplymentQueryPlansRespData applymentQueryPlans(String orderNumber) {
        ApplymentQueryPlansReq req = new ApplymentQueryPlansReq();
        req.setOrderNumber(orderNumber);
        ApplymentQueryPlansResp resp = loansApiService.applymentQueryplans(req);
        return resp.getData();
    }

    public List<PayGetBanklistItem> payGetbanklist() {
        PayGetBanklistResp resp = loansApiService.payGetbanklist(new PayGetBanklistReq());
        return resp.getData();
    }

    public void payPretiedcard(PayPretiedcardReq req) {
        req.setAccountName("薛倩");
        req.setAccountNo("6228480215110121391");
        req.setIdcardNo("450681199904105960");
        req.setMobile("13475804735");
        req.setOrderNumber("B34938953898539");
        PayPretiedcardResp resp = loansApiService.payPretiedcard(req);
    }

    public void payConfirmbindcard(PayConfirmbindcardReq req) {
        req.setAccountNo("");
        req.setAccountName("");
        req.setIdcardNo("");
        req.setBranchName("");
        req.setMobile("");
        req.setUniqueCode("");
        req.setSmsCode("");
        req.setOrderNumber("");
        PayConfirmbindcardResp resp = loansApiService.payConfirmbindcard(req);
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
        EsignSigncontractReq req = new EsignSigncontractReq();
        req.setOrderNumber(orderNumber);
        req.setNoticeType(noticeType);
        EsignSigncontractResp resp = loansApiService.esignSigncontract(req);
        return resp.getData();
    }

    public EsignMycontractRespData esignMycontract(String orderNumber) {
        EsignMycontractReq req = new EsignMycontractReq();
        req.setOrderNumber(orderNumber);
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

    public int applymentIndexCallback(ApplymentIndexCallbackReq req) {

        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        if (loan == null) return 1;

//        loan.setLoanStatus();

        loanMapper.updateByPrimaryKey(loan);

        return 0;
    }

    public int applymentApprovalCallback(ApplymentApprovalCallbackReq req) {

        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        if (loan == null) return 1;

//        loan.setLoanStatus();

        loanMapper.updateByPrimaryKey(loan);

        return 0;
    }

    public int payWithholdCallback(PayWithholdCallbackReq req) {

        Loan loan = loanMapper.selectByOrderNumber(req.getOrderNumber());

        if (loan == null) return 1;

//        loan.setLoanStatus();

        loanMapper.updateByPrimaryKey(loan);

        return 0;
    }

}
