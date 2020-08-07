package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_shop")
public class LoanShop implements Serializable {
    @Id
    private Long id;

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

    @Column(name = "enable_status")
    private Integer enableStatus;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取店铺名称
     *
     * @return shop_name - 店铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置店铺名称
     *
     * @param shopName 店铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取店铺地址
     *
     * @return shop_address - 店铺地址
     */
    public String getShopAddress() {
        return shopAddress;
    }

    /**
     * 设置店铺地址
     *
     * @param shopAddress 店铺地址
     */
    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress == null ? null : shopAddress.trim();
    }

    /**
     * 获取房东姓名
     *
     * @return owner_name - 房东姓名
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置房东姓名
     *
     * @param ownerName 房东姓名
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    /**
     * 获取房东电话
     *
     * @return owner_mobile - 房东电话
     */
    public String getOwnerMobile() {
        return ownerMobile;
    }

    /**
     * 设置房东电话
     *
     * @param ownerMobile 房东电话
     */
    public void setOwnerMobile(String ownerMobile) {
        this.ownerMobile = ownerMobile == null ? null : ownerMobile.trim();
    }

    /**
     * 获取店铺租金(单位：元)
     *
     * @return store_rent - 店铺租金(单位：元)
     */
    public Integer getStoreRent() {
        return storeRent;
    }

    /**
     * 设置店铺租金(单位：元)
     *
     * @param storeRent 店铺租金(单位：元)
     */
    public void setStoreRent(Integer storeRent) {
        this.storeRent = storeRent;
    }

    /**
     * 获取店铺面积
     *
     * @return shop_area - 店铺面积
     */
    public String getShopArea() {
        return shopArea;
    }

    /**
     * 设置店铺面积
     *
     * @param shopArea 店铺面积
     */
    public void setShopArea(String shopArea) {
        this.shopArea = shopArea == null ? null : shopArea.trim();
    }

    /**
     * 获取租约到期时间
     *
     * @return shop_expire - 租约到期时间
     */
    public String getShopExpire() {
        return shopExpire;
    }

    /**
     * 设置租约到期时间
     *
     * @param shopExpire 租约到期时间
     */
    public void setShopExpire(String shopExpire) {
        this.shopExpire = shopExpire == null ? null : shopExpire.trim();
    }

    /**
     * 获取租金支付周期
     *
     * @return shop_period - 租金支付周期
     */
    public String getShopPeriod() {
        return shopPeriod;
    }

    /**
     * 设置租金支付周期
     *
     * @param shopPeriod 租金支付周期
     */
    public void setShopPeriod(String shopPeriod) {
        this.shopPeriod = shopPeriod == null ? null : shopPeriod.trim();
    }

    /**
     * 获取租金支付日
     *
     * @return shop_payDate - 租金支付日
     */
    public String getShopPaydate() {
        return shopPaydate;
    }

    /**
     * 设置租金支付日
     *
     * @param shopPaydate 租金支付日
     */
    public void setShopPaydate(String shopPaydate) {
        this.shopPaydate = shopPaydate == null ? null : shopPaydate.trim();
    }

    /**
     * 获取店铺数量
     *
     * @return shop_num - 店铺数量
     */
    public Integer getShopNum() {
        return shopNum;
    }

    /**
     * 设置店铺数量
     *
     * @param shopNum 店铺数量
     */
    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    /**
     * @return enable_status
     */
    public Integer getEnableStatus() {
        return enableStatus;
    }

    /**
     * @param enableStatus
     */
    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    /**
     * @return del_flag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return created_date
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return created_by
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return updated_date
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * @return updated_by
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", shopName=").append(shopName);
        sb.append(", shopAddress=").append(shopAddress);
        sb.append(", ownerName=").append(ownerName);
        sb.append(", ownerMobile=").append(ownerMobile);
        sb.append(", storeRent=").append(storeRent);
        sb.append(", shopArea=").append(shopArea);
        sb.append(", shopExpire=").append(shopExpire);
        sb.append(", shopPeriod=").append(shopPeriod);
        sb.append(", shopPaydate=").append(shopPaydate);
        sb.append(", shopNum=").append(shopNum);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}