package cn.com.payu.modules.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LoanRecordModel {

    /**
     * 借款id
     */
    private Long loanId;

    /**
     * 借款编号
     */
    private String orderNumber;

    /**
     * 客户贷款金额(单位：元)
     */
    private Integer annuity;

    /**
     * 客户申请期限，详见字典说明
     */
    private Integer loanPeriod;

    /**
     * 借款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date loanDate;

    /**
     * 当前应还款
     */
    private BigDecimal currentRepayMoney;

    /**
     * 应还款总额
     */
    private BigDecimal totalRepayAmount;

    /**
     * 最近还款日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastRepayDate;

    /**
     * 还款状态
     */
    private Integer repayStatus;
    private String repayStatusDesc;

}
