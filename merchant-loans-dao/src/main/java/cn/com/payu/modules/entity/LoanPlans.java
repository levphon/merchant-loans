package cn.com.payu.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "d_loan_plans")
public class LoanPlans extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 外部id
     */
    @Column(name = "o_id")
    private String outerId;

    /**
     * 还款期数
     */
    @Column(name = "plan_periods_order")
    private Integer planPeriodsOrder;

    /**
     * 应还日期（账单日）
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Column(name = "plan_repay_time")
    private Date planRepayTime;

    /**
     * 应还本金
     */
    @Column(name = "plan_repay_principal")
    private BigDecimal planRepayPrincipal;

    /**
     * 应还合计
     */
    @Column(name = "plan_repay_total")
    private BigDecimal planRepayTotal;

    /**
     * 剩余本金
     */
    @Column(name = "plan_remain_principal")
    private BigDecimal planRemainPrincipal;

    /**
     * 还款状态：1尚未还清2已还清
     */
    @Column(name = "plan_status")
    private Integer planStatus;

    @Transient
    private String planStatusDesc;

}