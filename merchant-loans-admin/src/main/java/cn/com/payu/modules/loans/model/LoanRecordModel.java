package cn.com.payu.modules.loans.model;

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
     * 当期期数
     */
    private Integer currentPeriod;

    /**
     * 当期应还金额
     */
    private BigDecimal currentPeriodRepayMoney;

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
     * 应还合计（剩余全部应还）
     */
    private BigDecimal totalRemainRepayAmount;

    /**
     * 还款状态
     */
    private Integer repayStatus;
    private String repayStatusDesc;

}
