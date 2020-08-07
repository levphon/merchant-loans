package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_address")
public class LoanAddress implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 与谁居住，详见字典说明
     */
    @Column(name = "together_dwell")
    private Integer togetherDwell;

    /**
     * 住宅类型，详见字典说明
     */
    @Column(name = "housing_type")
    private Integer housingType;

    /**
     * 起始居住日期,时间戳
     */
    @Column(name = "live_date")
    private Date liveDate;

    /**
     * 每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     */
    @Column(name = "month_rent")
    private Float monthRent;

    /**
     * 现地址的省份
     */
    @Column(name = "present_province")
    private String presentProvince;

    /**
     * 现地址的城市
     */
    @Column(name = "present_city")
    private String presentCity;

    /**
     * 现地址的地区
     */
    @Column(name = "present_region")
    private String presentRegion;

    /**
     * 现地址的详细地址
     */
    @Column(name = "present_address")
    private String presentAddress;

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
     * 获取借款id
     *
     * @return loan_id - 借款id
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * 设置借款id
     *
     * @param loanId 借款id
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * 获取与谁居住，详见字典说明
     *
     * @return together_dwell - 与谁居住，详见字典说明
     */
    public Integer getTogetherDwell() {
        return togetherDwell;
    }

    /**
     * 设置与谁居住，详见字典说明
     *
     * @param togetherDwell 与谁居住，详见字典说明
     */
    public void setTogetherDwell(Integer togetherDwell) {
        this.togetherDwell = togetherDwell;
    }

    /**
     * 获取住宅类型，详见字典说明
     *
     * @return housing_type - 住宅类型，详见字典说明
     */
    public Integer getHousingType() {
        return housingType;
    }

    /**
     * 设置住宅类型，详见字典说明
     *
     * @param housingType 住宅类型，详见字典说明
     */
    public void setHousingType(Integer housingType) {
        this.housingType = housingType;
    }

    /**
     * 获取起始居住日期,时间戳
     *
     * @return live_date - 起始居住日期,时间戳
     */
    public Date getLiveDate() {
        return liveDate;
    }

    /**
     * 设置起始居住日期,时间戳
     *
     * @param liveDate 起始居住日期,时间戳
     */
    public void setLiveDate(Date liveDate) {
        this.liveDate = liveDate;
    }

    /**
     * 获取每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     *
     * @return month_rent - 每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     */
    public Float getMonthRent() {
        return monthRent;
    }

    /**
     * 设置每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     *
     * @param monthRent 每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     */
    public void setMonthRent(Float monthRent) {
        this.monthRent = monthRent;
    }

    /**
     * 获取现地址的省份
     *
     * @return present_province - 现地址的省份
     */
    public String getPresentProvince() {
        return presentProvince;
    }

    /**
     * 设置现地址的省份
     *
     * @param presentProvince 现地址的省份
     */
    public void setPresentProvince(String presentProvince) {
        this.presentProvince = presentProvince == null ? null : presentProvince.trim();
    }

    /**
     * 获取现地址的城市
     *
     * @return present_city - 现地址的城市
     */
    public String getPresentCity() {
        return presentCity;
    }

    /**
     * 设置现地址的城市
     *
     * @param presentCity 现地址的城市
     */
    public void setPresentCity(String presentCity) {
        this.presentCity = presentCity == null ? null : presentCity.trim();
    }

    /**
     * 获取现地址的地区
     *
     * @return present_region - 现地址的地区
     */
    public String getPresentRegion() {
        return presentRegion;
    }

    /**
     * 设置现地址的地区
     *
     * @param presentRegion 现地址的地区
     */
    public void setPresentRegion(String presentRegion) {
        this.presentRegion = presentRegion == null ? null : presentRegion.trim();
    }

    /**
     * 获取现地址的详细地址
     *
     * @return present_address - 现地址的详细地址
     */
    public String getPresentAddress() {
        return presentAddress;
    }

    /**
     * 设置现地址的详细地址
     *
     * @param presentAddress 现地址的详细地址
     */
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress == null ? null : presentAddress.trim();
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
        sb.append(", loanId=").append(loanId);
        sb.append(", togetherDwell=").append(togetherDwell);
        sb.append(", housingType=").append(housingType);
        sb.append(", liveDate=").append(liveDate);
        sb.append(", monthRent=").append(monthRent);
        sb.append(", presentProvince=").append(presentProvince);
        sb.append(", presentCity=").append(presentCity);
        sb.append(", presentRegion=").append(presentRegion);
        sb.append(", presentAddress=").append(presentAddress);
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