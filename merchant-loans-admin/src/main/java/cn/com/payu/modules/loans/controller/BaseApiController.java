package cn.com.payu.modules.loans.controller;

import cn.com.payu.modules.loans.req.AbstractApiCallbackReq;
import com.glsx.plat.common.utils.SignUtils;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.exception.SystemMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author payu
 */
@Slf4j
@RestController
public class BaseApiController {

    /**
     * 通用验证请求签名
     *
     * @param req
     * @param localSecret
     * @param localSalt
     */
    protected void verifySign(AbstractApiCallbackReq req, String localSecret, String localSalt) {
        Map<String, String> params = SignUtils.getSignTreeMap(req);
        String sign = params.remove(SignUtils.SIGN);
        String paramsJson = SignUtils.getSignTreeJson(req);
        String localSign = SignUtils.sign(localSecret, paramsJson, localSalt);
        log.info("参与签名参数：" + paramsJson);
        log.info("调用方生成的签名为：" + sign);
        log.info("系统方生成的签名为：" + localSign);
        if (!localSign.equalsIgnoreCase(sign)) {
            throw BusinessException.create(SystemMessage.SIGN_ERROR);
        }
    }

}
