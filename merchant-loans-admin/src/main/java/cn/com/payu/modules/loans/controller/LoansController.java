package cn.com.payu.modules.loans.controller;

import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.loans.service.LoansBizService;
import com.glsx.plat.common.annotation.SysLog;
import com.glsx.plat.core.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class LoansController {

    @Autowired
    private LoansBizService loansBizService;

    @GetMapping("/basics/getLoansProducts")
    public R basicsGetLoansProducts() {
        List<BasicsGetLoansProductsItem> itemList = loansBizService.basicsGetLoansProducts();
        return R.ok().data(itemList);
    }

    @GetMapping("/basics/getLoansPeriods")
    public R basicsGetLoansPeriods() {
        Map<String, String> map = loansBizService.basicsGetLoansPeriods();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getHousingTypes")
    public R basicsGethousingTypes() {
        Map<String, String> map = loansBizService.basicsGetHousingTypes();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getTogetherDwellList")
    public R basicsGetTogetherDwellList() {
        Map<String, String> map = loansBizService.basicsGetTogetherDwellList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getRelationTypelList")
    public R basicsGetRelationTypelList() {
        Map<String, String> map = loansBizService.basicsGetRelationTypelList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getLoanPurposeList")
    public R basicsGetLoanPurposeList() {
        Map<String, String> map = loansBizService.basicsGetLoanPurposeList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getEducationList")
    public R basicsGetEducationList() {
        Map<String, String> map = loansBizService.basicsGetEducationList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getMarriageList")
    public R basicsGetMarriageList() {
        Map<String, String> map = loansBizService.basicsGetMarriageList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getUnitTypeList")
    public R basicsGetUnitTypeList() {
        Map<String, String> map = loansBizService.basicsGetUnitTypeList();
        return R.ok().data(map);
    }

    @GetMapping("/basics/getIndustryTypeList")
    public R basicsGetIndustryTypeList(Integer pid) {
        List<BasicsGetIndustryTypeListItem> itemList = loansBizService.basicsGetIndustryTypeList(pid);
        return R.ok().data(itemList);
    }

    @SysLog
    @PostMapping(value = "/applyment/index")
    public R applymentIndex(@RequestBody @Valid ApplymentIndexReq req) {
        String orderNumber = loansBizService.applymentIndex(req);
        return R.ok().data(orderNumber);
    }

    @SysLog
    @PostMapping(value = "/applyment/reject")
    public R applymentReject(@RequestBody @Valid ApplymentRejectReq req) {
        loansBizService.applymentReject(req);
        return R.ok();
    }

    @GetMapping(value = "/applyment/getSignState")
    public R applymentGetSignState(String orderNumber) {
        ApplymentGetSignStateRespData data = loansBizService.applymentGetSignState(orderNumber);
        return R.ok().data(data);
    }

    @GetMapping(value = "/applyment/queryOrder")
    public R applymentQueryOrder(String orderNumber) {
        ApplymentQueryOrderRespData data = loansBizService.applymentQueryOrder(orderNumber);
        return R.ok().data(data);
    }

    @GetMapping(value = "/applyment/queryPlans")
    public R applymentQueryPlans(String orderNumber) {
        ApplymentQueryPlansRespData data = loansBizService.applymentQueryPlans(orderNumber);
        return R.ok().data(data);
    }

    @PostMapping(value = "/esign/signcontract")
    public R esignSigncontract(@RequestBody @Valid EsignSigncontractReq req) {
        EsignSigncontractRespData data = loansBizService.esignSigncontract(req.getOrderNumber(), req.getNoticeType());
        return R.ok().data(data);
    }

    @GetMapping(value = "/esign/mycontract")
    public R esignMycontract(String orderNumber) {
        EsignMycontractRespData data = loansBizService.esignMycontract(orderNumber);
        return R.ok().data(data);
    }

    @GetMapping(value = "/esign/getSignUrl")
    public R esignGetSignUrl(String orderNumber, Integer signType) {
        EsignGetSignUrlRespData data = loansBizService.esignGetSignUrl(orderNumber, signType);
        return R.ok().data(data);
    }

    @GetMapping(value = "/pay/getbanklist")
    public R payGetbanklist() {
        List<PayGetBanklistItem> itemList = loansBizService.payGetbanklist();
        return R.ok().data(itemList);
    }

    @SysLog
    @PostMapping(value = "/pay/pretiedcard")
    public R payPretiedcard(@RequestBody @Valid PayPretiedcardReq req) {
        loansBizService.payPretiedcard(req);
        return R.ok();
    }

    @SysLog
    @PostMapping(value = "/pay/confirmbindcard")
    public R payConfirmbindcard(@RequestBody @Valid PayConfirmbindcardReq req) {
        loansBizService.payConfirmbindcard(req);
        return R.ok();
    }

    @GetMapping(value = "/pay/getPayInfo")
    public R payGetPayInfo(String orderNumber, String repayType) {
        PayGetPayInfoRespData data = loansBizService.payGetPayInfo(orderNumber, repayType);
        return R.ok().data(data);
    }

    @GetMapping(value = "/pay/querywithhold")
    public R payQuerywithhold(String tradeNumber) {
        PayQueryWithholdResp resp = loansBizService.payQuerywithhold(tradeNumber);
        return R.ok().data(resp.getMsg());
    }

}
