package cn.com.payu.modules.loans.req;

import lombok.Data;

/**
 * 回调请求
 *
 * @author payu
 */
@Data
public abstract class AbstractApiCallbackReq {

    /**
     * 签名
     */
    private String sign;

}
