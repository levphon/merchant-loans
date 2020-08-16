package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_provident_fund")
public class LoanProvidentFund extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 公积金账号
     */
    private String account;

    /**
     * 公积金密码
     */
    private String password;

}