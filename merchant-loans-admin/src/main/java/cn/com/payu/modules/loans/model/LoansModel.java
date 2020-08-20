package cn.com.payu.modules.loans.model;

import lombok.Data;

@Data
public class LoansModel {

    private String orderNumber;

    private String name;

    private String phoneNumber;

    private String idcardNo;

    private Integer annuity;

    private Integer loanPeriod;

    private Integer loanStatus;
    private String loanStatusDesc;

    private Integer protocolStatus;//授权书：0-未签署，1-签署未完成，2-已完成签署
    private String protocolMsg;//授权书状态描述

    private Integer contractStatus;//合同状态：0-未签署，1-签署未完成，2-已完成签署
    private String contractMsg;//合同状态描述

    private Integer bindStatus;//绑卡状态：1未绑卡，2已绑卡
    private String bindStatusDesc;

}
