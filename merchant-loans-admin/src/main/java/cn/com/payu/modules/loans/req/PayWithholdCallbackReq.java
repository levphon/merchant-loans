package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class PayWithholdCallbackReq extends AbstractApiCallbackReq {

    //还款期数
    private Integer periodOrder;

    //是否结清 false:尚未结清 true:已结清
    private Boolean isFinish;

}
