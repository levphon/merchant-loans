package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan")
public class Loan extends BaseEntity {

    /**
     * 商户订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 对方订单号
     */
    @Column(name = "apply_number")
    private String applyNumber;

    /**
     * 贷款产品id，我方提供
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 客户贷款金额(单位：元)
     */
    private Integer annuity;

    /**
     * 客户贷款用途，详见字典说明
     */
    @Column(name = "loan_purpose")
    private Integer loanPurpose;

    /**
     * 客户申请期限，详见字典说明
     */
    @Column(name = "loan_period")
    private Integer loanPeriod;

    /**
     * 建议费率，保留两位小数，默认为：0
     */
    @Column(name = "merchant_rate")
    private Float merchantRate;

    /**
     * 还款方式，详见字典说明，默认为：2
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    /**
     * 状态，详见字典说明
     */
    @Column(name = "loan_status")
    private Integer loanStatus;

    /**
     * 授权书：0-未签署，1-签署未完成，2-已完成签署
     */
    @Column(name = "protocol_status")//
    private Integer protocolStatus;

    /**
     * 合同状态：0-未签署，1-签署未完成，2-已完成签署
     */
    @Column(name = "contract_status")
    private Integer contractStatus;

    /**
     * 审批金额
     */
    @Column(name = "audit_amount")
    private Integer auditAmount;

    /**
     * 审批期限
     */
    @Column(name = "audit_period")
    private Integer auditPeriod;

}