package cn.com.payu.modules.loans.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ApplymentApprovalCallbackReq extends AbstractApiCallbackReq {

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
    //业务类型描述
    private String description;
    //业务原因
    private String reason;

    //对方审批金额(审核通过回调，其他场景下无该字段)
    private Integer auditAmount;
    //对方审批期限(审核通过回调，其他场景下无该字段)
    private Integer auditPeriod;

}
