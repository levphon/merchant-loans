package cn.com.payu.modules.loans.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PayWithholdCallbackReq extends AbstractApiCallbackReq {

    //业务流水号
    @NotBlank(message = "业务流水号不能为空")
    private String callbackNumber;
    //业务类型
    @NotBlank(message = "业务类型不能为空")
    private Integer callbackType;
    //商户订单号
    @NotBlank(message = "商户订单号不能为空")
    private String orderNumber;
    //我方订单号
    @NotBlank(message = "你方订单号不能为空")
    private String applyNumber;

    //还款期数
    private Integer periodOrder;
    //是否结清 false:尚未结清 true:已结清
    private Boolean isFinish;

    //业务类型描述
    private String description;
    //业务原因
    private String reason;

}
