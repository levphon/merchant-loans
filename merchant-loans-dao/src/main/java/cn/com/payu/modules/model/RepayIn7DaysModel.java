package cn.com.payu.modules.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RepayIn7DaysModel {

    /**
     * 借款id
     */
    private Integer loanId;

    /**
     * 客户申请期限，详见字典说明
     */
    private Integer loanPeriod;

    /**
     * 已还期数
     */
    private Integer repayedPeriod;

    /**
     * 当前应还款
     */
    private BigDecimal currentRepayMoney;

    /**
     * 本期应还
     */
    private Integer currentPeriodRepayMoney;

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
