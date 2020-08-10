package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexCallbackReq extends AbstractApiCallbackReq {

    //对方审批金额(审核通过回调，其他场景下无该字段)
    private Integer auditAmount;

    //对方审批期限(审核通过回调，其他场景下无该字段)
    private Integer auditPeriod;

}
