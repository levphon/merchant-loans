package cn.com.payu.modules.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderModel {

//
//业务员编号
//
//
//借款额度
//进件放款状态
//绑卡状态
//

//    dl.id,dl.order_number,dlp.name,dlp.phone_number,dl.annuity,dl.loan_status,dcb.bind_status

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
     * 客户手机号
     */
    private String phoneNumber;

    /**
     * 借款额度
     */
    private Integer annuity;

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
