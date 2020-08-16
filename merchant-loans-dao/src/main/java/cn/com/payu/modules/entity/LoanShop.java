package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_shop")
public class LoanShop extends BaseEntity {

    /**
     * 店铺名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 店铺地址
     */
    @Column(name = "shop_address")
    private String shopAddress;

    /**
     * 房东姓名
     */
    @Column(name = "owner_name")
    private String ownerName;

    /**
     * 房东电话
     */
    @Column(name = "owner_mobile")
    private String ownerMobile;

    /**
     * 店铺租金(单位：元)
     */
    @Column(name = "store_rent")
    private Integer storeRent;

    /**
     * 店铺面积
     */
    @Column(name = "shop_area")
    private String shopArea;

    /**
     * 租约到期时间
     */
    @Column(name = "shop_expire")
    private String shopExpire;

    /**
     * 租金支付周期
     */
    @Column(name = "shop_period")
    private String shopPeriod;

    /**
     * 租金支付日
     */
    @Column(name = "shop_payDate")
    private String shopPaydate;

    /**
     * 店铺数量
     */
    @Column(name = "shop_num")
    private Integer shopNum;

}