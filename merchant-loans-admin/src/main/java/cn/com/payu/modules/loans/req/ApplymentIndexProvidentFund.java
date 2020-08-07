package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexProvidentFund {

    /**
     * 公积金账号
     */
    private String account;

    /**
     * 公积金密码
     */
    private String password;

}
