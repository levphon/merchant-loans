package cn.com.payu.modules.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class LoanRecordDetails {

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
     * 客户申请期限
     */
    private Integer loanPeriod;

    /**
     * 已还期数
     */
    private Integer repayedPeriod;

    /**
     * 逾期期数
     */
    private Integer overduePeriod;

    /**
     * 应还本金
     */
    private BigDecimal planRepayPrincipal;

    /**
     * 应还合计
     */
    private BigDecimal planRepayTotal;

    /**
     * 剩余本金
     */
    private BigDecimal planRemainPrincipal;

    /**
     * 还款计划
     */
    private List<LoanPlansModel> plans;

    /**
     * 还款状态
     */
    private Integer repayStatus;

    /**
     * 当前应还款
     */
    private BigDecimal currentRepayMoney;

    /**
     * 最近还款日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastRepayDate;

}
