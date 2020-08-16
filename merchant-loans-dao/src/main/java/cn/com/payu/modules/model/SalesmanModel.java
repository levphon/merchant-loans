package cn.com.payu.modules.model;

import lombok.Data;

import java.util.Date;

@Data
public class SalesmanModel {

    private Long id;

    /**
     * 业务员名称
     */
    private String name;

    /**
     * 业务员编号
     */
    private String jobNo;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 省份code
     */
    private String provCode;

    /**
     * 城市code
     */
    private String cityCode;

    /**
     * 县区code
     */
    private String areaCode;

    /**
     * 地址
     */
    private String address;

    /**
     * 启用状态
     */
    private Integer enableStatus;
    private String enableStatusDesc;

    private Date createdDate;

}
