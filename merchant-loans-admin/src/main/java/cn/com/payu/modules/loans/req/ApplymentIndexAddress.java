package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexAddress {

    /**
     * 与谁居住，详见字典说明
     */
    private Integer togetherDwell;

    /**
     * 住宅类型，详见字典说明
     */
    private Integer housingType;

    /**
     * 起始居住日期,时间戳，时间戳
     */
    private Long liveDate;

    /**
     * 每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     */
    private BigDecimal monthRent;

    /**
     * 现地址的省份
     */
    private String presentProvince;

    /**
     * 现地址的城市
     */
    private String presentCity;

    /**
     * 现地址的地区
     */
    private String presentRegion;

    /**
     * 现地址的详细地址
     */
    private String presentAddress;

}
