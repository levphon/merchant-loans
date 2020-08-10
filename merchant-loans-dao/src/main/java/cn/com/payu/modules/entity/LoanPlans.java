package cn.com.payu.modules.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "d_loan_plans")
public class LoanPlans implements Serializable {
    @Id
    private Long id;

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

    @Column(name = "enable_status")
    private Integer enableStatus;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    private static final long serialVersionUID = 1L;

}