package cn.com.payu.modules.customer.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginByMobileDTO {

    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @NotBlank(message = "验证码不能为空")
    private String code;

    private String openid;

}
