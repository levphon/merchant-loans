package cn.com.payu.modules.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "d_customer")
public class Customer extends BaseEntity {

    private String account;

    private String avatar;

    @JsonIgnore
    private String password;

    private String phone;

    private String realname;

    private String username;

    @Column(name = "mini_openid")
    private String miniOpenid;

    @Column(name = "wx_openid")
    private String wxOpenid;

}