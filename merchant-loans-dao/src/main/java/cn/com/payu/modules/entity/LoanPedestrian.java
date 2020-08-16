package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "d_loan_pedestrian")
public class LoanPedestrian extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 人行征信的账号
     */
    private String account;

    /**
     * 人行征信的密码
     */
    private String password;

    /**
     * 人行征信的授权码
     */
    @Column(name = "authorization_code")
    private String authorizationCode;

    /**
     * 有效期，时间戳
     */
    @Column(name = "expired_time")
    private Date expiredTime;

}