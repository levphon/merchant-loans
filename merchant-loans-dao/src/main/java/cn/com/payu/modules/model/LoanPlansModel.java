package cn.com.payu.modules.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class LoanPlansModel {

    private Long loanId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态
     */
    private Integer loanStatus;

    /**
     * 外部id
     */
    private String outerId;

    /**
     * 还款期数
     */
    private Integer planPeriodsOrder;

    /**
     * 应还日期（账单日）
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planRepayTime;

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
     * 还款状态：1尚未还清2已还清
     */
    private Integer planStatus;
    private String planStatusDesc;

    /**
     * 逾期天数
     */
    private Integer overdueDays;

}
