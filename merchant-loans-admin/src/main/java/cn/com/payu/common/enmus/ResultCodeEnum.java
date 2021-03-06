package cn.com.payu.common.enmus;

import lombok.Getter;

/**
 * @author liuyf
 * @Title ResultCodeEnum.java
 * @Package com.glsx.vasp.constants
 * @Description 结果集
 * @date 2019年10月22日 上午10:51:53
 */
@Getter
public enum ResultCodeEnum {

    //登录相关
    INCORRECT_CREDENTIALS(300, "用户名或密码错误"),
    UNKNOWN_ACCOUNT(301, "此账号不存在"),
    LOCKED_ACCOUNT(302, "账号已被禁用"),
    VERIFY_CODE_TIMEOUT(310, "验证码已过期"),
    INCORRECT_CAPTCHA(311, "验证码错误"),

    USERNAME_NOT_EXIST(300, "手机号不存在"),
    SMS_VERIFY_CODE_TIMEOUT(301, "短信验证码已过期"),
    SMS_VERIFY_CODE_NOT_RIGHT(302, "短信验证码错误"),
    SMS_VERIFY_CODE_SEND_FAIL(303, "短信验证码发送失败"),
    SMS_VERIFY_CODE_SEND_LIMIT(304, "短信发送今日已达上限"),
    UNFOLLOW_OFFICIAL_ACCOUNT(308, "未关注公众号");
    /***************************业务相关******************************/

    /**
     * 状态码
     */
    private int code;
    /**
     * 状态码对应的信息
     */
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
