package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.Expose;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @Expose
    @NotBlank(message = "签名不能为空")
    private String sign;

    //业务流水号
    @NotBlank(message = "业务流水号不能为空")
    private String callbackNumber;
    //业务类型
    @NotNull(message = "业务类型不能为空")
    private Integer callbackType;
    //商户订单号
    @NotBlank(message = "商户订单号不能为空")
    private String orderNumber;
    //对方订单号,审核不通过这个为空
//    @NotBlank(message = "订单号不能为空")
    private String applyNumber;

    //业务类型描述
    private String description;

    //业务原因
    private String reason;

}
