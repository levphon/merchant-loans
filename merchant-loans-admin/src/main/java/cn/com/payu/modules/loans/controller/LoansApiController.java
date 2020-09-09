package cn.com.payu.modules.loans.controller;

import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.ApplymentIndexCallbackReq;
import cn.com.payu.modules.loans.service.LoansBizService;
import com.glsx.plat.common.annotation.SysLog;
import com.glsx.plat.common.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
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

        boolean flag = this.verifySign(req, loansConfig.getSecret(), loansConfig.getSalt());
        if (!flag) return "fail";

        int rtnCode = loansBizService.applymentCallback(req);

        return rtnCode == 0 ? "success" : "fail";
    }

    /**
     * 通用验证请求签名
     *
     * @param req
     * @param localSecret
     * @param localSalt
     */
    protected boolean verifySign(ApplymentIndexCallbackReq req, String localSecret, String localSalt) {
        String paramsJson = SignUtils.getSignTreeJson(req);
        log.info("参与签名参数：" + paramsJson);
        String localSign = SignUtils.sign(localSecret, paramsJson, localSalt);
        log.info("调用方生成的签名为：" + req.getSign());
        log.info("系统方生成的签名为：" + localSign);
        return localSign.equalsIgnoreCase(req.getSign());
    }

}
