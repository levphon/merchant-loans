package cn.com.payu.modules.loans.controller;

import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.ApplymentApprovalCallbackReq;
import cn.com.payu.modules.loans.req.ApplymentIndexCallbackReq;
import cn.com.payu.modules.loans.req.PayWithholdCallbackReq;
import cn.com.payu.modules.loans.service.LoansBizService;
import com.glsx.plat.common.annotation.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/mloans")
public class LoansApiController extends BaseApiController {

    @Autowired
    private LoansConfig loansConfig;

    @Autowired
    private LoansBizService loansBizService;

    @SysLog("进件回调")
    @PostMapping("/callback/applymentindex")
    public String applymentIndexCallback(@RequestBody @Valid ApplymentIndexCallbackReq req) {

        verifySign(req, loansConfig.getSecret(), loansConfig.getSalt());

        int rtnCode = loansBizService.applymentIndexCallback(req);

        return rtnCode == 0 ? "success" : "fail";
    }

    @SysLog("风控审核回调")
    @PostMapping("/callback/applymentapproval")
    public String applymentApprovalCallback(@RequestBody @Valid ApplymentApprovalCallbackReq req) {

        verifySign(req, loansConfig.getSecret(), loansConfig.getSalt());

        int rtnCode = loansBizService.applymentApprovalCallback(req);

        return rtnCode == 0 ? "success" : "fail";
    }

    @SysLog("代扣还款的回调")
    @PostMapping("/callback/paywithhold")
    public String payWithholdCallback(@RequestBody @Valid PayWithholdCallbackReq req) {

        verifySign(req, loansConfig.getSecret(), loansConfig.getSalt());

        int rtnCode = loansBizService.payWithholdCallback(req);

        return rtnCode == 0 ? "success" : "fail";
    }

}
