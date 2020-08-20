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
     * 借款日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date loanDate;

    /**
     * 当期期数
     */
    private Integer currentPeriod;

    /**
     * 当期应还金额
     */
    private BigDecimal currentPeriodRepayMoney;

    /**
     * 当期本金
     */
    private BigDecimal currentPeriodPrincipal;

    /**
     * 当期还款日
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date currentPeriodRepayDate;

    /**
     * 当前应还款总额(当期+逾期)
     */
    private BigDecimal currentRepayTotalMoney;

    /**
     * 当前应还款本金(当期+逾期)
     */
    private BigDecimal currentRepayTotalPrincipal;

    /**
     * 已还期数
     */
    private Integer repaidPeriod;

    /**
     * 逾期期数
     */
    private Integer overduePeriod;

    /**
     * 剩余本金合计（剩余全部本金）
     */
    private BigDecimal totalRemainPrincipal;

    /**
     * 应还合计（剩余全部应还）
     */
    private BigDecimal totalRemainRepayAmount;

    /**
     * 还款计划
     */
    private List<LoanPlansModel> plans;

    /**
     * 还款状态
     */
    private Integer repayStatus;

}
