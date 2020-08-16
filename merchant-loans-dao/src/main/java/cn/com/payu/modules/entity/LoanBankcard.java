package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_bankcard")
public class LoanBankcard extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 开户姓名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 借记卡号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 开户身份证号
     */
    @Column(name = "idcard_no")
    private String idcardNo;

    /**
     * 预留手机号
     */
    private String mobile;

    /**
     * 开户行
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 开户分行
     */
    @Column(name = "branch_name")
    private String branchName;

    /**
     * 绑定通道：如宝付、快付通、银联等,暂时无用
     */
    @Column(name = "bind_channel")
    private Integer bindChannel;

    /**
     * 绑定状态
     */
    @Column(name = "bind_status")
    private Integer bindStatus;

    /**
     * 绑卡鉴权认证码
     */
    @Column(name = "unique_code")
    private String uniqueCode;

    /**
     * 使用状态
     */
    @Column(name = "use_status")
    private Integer useStatus;

}