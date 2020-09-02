package cn.com.payu.modules.loans.model;

import lombok.Data;

import java.util.Date;

@Data
public class PreSigncontractModel {

    private String accountName;

    private String accountNo;

    private String idcardNo;

    private String mobile;

    private Integer annuity;

    private Date applyTime;

}
