package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexCallbackReq extends AbstractApiCallbackReq {

    //对方审批金额(审核通过回调，其他场景下无该字段)
    private Integer auditAmount;

    //对方审批期限(审核通过回调，其他场景下无该字段)
    private Integer auditPeriod;

    //还款期数
    private Integer periodOrder;

    //是否结清 false:尚未结清 true:已结清
    private Boolean isFinish;

}
