package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_salesman")
public class Salesman extends BaseEntity {

    /**
     * 业务员名称
     */
    private String name;

    /**
     * 业务员编号
     */
    @Column(name = "s_no")
    private String sNo;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 省份code
     */
    @Column(name = "prov_code")
    private String provCode;

    /**
     * 城市code
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 县区code
     */
    @Column(name = "area_code")
    private String areaCode;

    /**
     * 地址
     */
    private String address;

}