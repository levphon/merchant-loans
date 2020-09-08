package cn.com.payu.modules.loans.controller;

import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.ApplymentIndexCallbackReq;
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

    @SysLog("进件结果 风控审核 代扣还款等回调")
    @PostMapping("/callback/applyment")
    public String applymentCallback(@RequestBody @Valid ApplymentIndexCallbackReq req) {

        boolean flag = verifySign(req, loansConfig.getSecret(), loansConfig.getSalt());
        if (!flag) return "fail";

        int rtnCode = loansBizService.applymentCallback(req);

        return rtnCode == 0 ? "success" : "fail";
    }

}
