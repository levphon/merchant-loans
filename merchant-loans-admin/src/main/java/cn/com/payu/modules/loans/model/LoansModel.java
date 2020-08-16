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

    private Integer bindStatus;
    private String bindStatusDesc;

}
