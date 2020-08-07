package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexPedestrian {

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
    private String authorizationCode;
    /**
     * 有效期，时间戳
     */
    private Long expiredTime;

}
