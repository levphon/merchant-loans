package cn.com.payu.modules.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "d_user")
public class User extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 加密盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 类似微信UnionID
     */
    private String account;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 手机号
     */
    private String phone;

}