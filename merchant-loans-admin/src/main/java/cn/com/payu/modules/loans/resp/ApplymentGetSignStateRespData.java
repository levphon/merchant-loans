package cn.com.payu.modules.loans.resp;

import lombok.Data;

@Data
public class ApplymentGetSignStateRespData {

    private String merchantNumber;//商户订单号
    private String applyNumber;//我方订单号
    private Integer protocolStatus;//授权书：0-未签署，1-签署未完成，2-已完成签署
    private String protocolMsg;//授权书状态描述
    private Integer contractStatus;//合同状态：0-未签署，1-签署未完成，2-已完成签署
    private String contractMsg;//合同状态描述

}
