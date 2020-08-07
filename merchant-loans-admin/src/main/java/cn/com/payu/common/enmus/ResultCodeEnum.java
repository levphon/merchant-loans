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
    UNKNOWN_ACCOUNT(301, "此账户不存在"),
    LOCKED_ACCOUNT(302, "账户已被禁用"),
    VERIFY_CODE_TIMEOUT(310, "验证码已过期"),
    INCORRECT_CAPTCHA(311, "验证码错误");
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
