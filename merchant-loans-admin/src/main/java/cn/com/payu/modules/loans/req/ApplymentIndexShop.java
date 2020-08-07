package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexShop {

    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺地址
     */
    private String shopAddress;
    /**
     * 房东姓名
     */
    private String ownerName;
    /**
     * 房东电话
     */
    private String ownerMobile;
    /**
     * 店铺租金(单位：元)
     */
    private BigDecimal storeRent;
    /**
     * 店铺面积
     */
    private String shopArea;
    /**
     * 租约到期时间
     */
    private String shopExpire;
    /**
     * 租金支付周期
     */
    private String shopPeriod;
    /**
     * 租金支付日
     */
    private String shopPayDate;
    /**
     * 店铺数量
     */
    private String shopNum;

}
