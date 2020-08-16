package cn.com.payu.modules.model;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class OrderModel {

    private Long id;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 业务员编号
     */
    private String salesmanNo;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户证件号码
     */
    private String certificateNumber;

    /**
     * 客户手机号
     */
    private String phoneNumber;

    /**
     * 借款额度、期数
     */
    private Integer annuity;
    private Integer loanPeriod;

    /**
     * 审批额度、期数
     */
    private Integer auditAmount;
    private Integer auditPeriod;

    /**
     * 进件放款状态
     */
    private Integer loanStatus;
    private String loanStatusDesc;

    /**
     * 绑卡状态
     */
    private Integer bindStatus;
    private String bindStatusDesc;

    /**
     * 还款状态
     */
    private Integer repayStatus;
    private String repayStatusDesc;

    private Date createdDate;

}
