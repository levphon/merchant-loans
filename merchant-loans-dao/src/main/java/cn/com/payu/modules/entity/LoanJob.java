package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_job")
public class LoanJob implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 客户类型 1：工薪类,2：生意类
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 经营时间(生意类),时间戳
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 行业类别的编码
     */
    @Column(name = "industry_code")
    private String industryCode;

    /**
     * 公司电话
     */
    @Column(name = "contact_number")
    private String contactNumber;

    /**
     * 公司营业额,单位：元(生意类)，浮点数，保留2位
     */
    @Column(name = "month_turnover")
    private Float monthTurnover;

    /**
     * 公司地址
     */
    @Column(name = "operate_address")
    private String operateAddress;

    /**
     * 入职时间(工薪类),时间戳
     */
    @Column(name = "hired_time")
    private Date hiredTime;

    /**
     * 入职职位(工薪类)
     */
    private String station;

    /**
     * 薪水,单位：元(工薪类)，浮点数，保留2位
     */
    private Float wage;

    /**
     * 单位性质(工薪类)，详见字典说明
     */
    @Column(name = "unitType")
    private Integer unittype;

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
     * 获取客户类型 1：工薪类,2：生意类
     *
     * @return business_type - 客户类型 1：工薪类,2：生意类
     */
    public Integer getBusinessType() {
        return businessType;
    }

    /**
     * 设置客户类型 1：工薪类,2：生意类
     *
     * @param businessType 客户类型 1：工薪类,2：生意类
     */
    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取经营时间(生意类),时间戳
     *
     * @return operate_time - 经营时间(生意类),时间戳
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * 设置经营时间(生意类),时间戳
     *
     * @param operateTime 经营时间(生意类),时间戳
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取行业类别的编码
     *
     * @return industry_code - 行业类别的编码
     */
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * 设置行业类别的编码
     *
     * @param industryCode 行业类别的编码
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode == null ? null : industryCode.trim();
    }

    /**
     * 获取公司电话
     *
     * @return contact_number - 公司电话
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 设置公司电话
     *
     * @param contactNumber 公司电话
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    /**
     * 获取公司营业额,单位：元(生意类)，浮点数，保留2位
     *
     * @return month_turnover - 公司营业额,单位：元(生意类)，浮点数，保留2位
     */
    public Float getMonthTurnover() {
        return monthTurnover;
    }

    /**
     * 设置公司营业额,单位：元(生意类)，浮点数，保留2位
     *
     * @param monthTurnover 公司营业额,单位：元(生意类)，浮点数，保留2位
     */
    public void setMonthTurnover(Float monthTurnover) {
        this.monthTurnover = monthTurnover;
    }

    /**
     * 获取公司地址
     *
     * @return operate_address - 公司地址
     */
    public String getOperateAddress() {
        return operateAddress;
    }

    /**
     * 设置公司地址
     *
     * @param operateAddress 公司地址
     */
    public void setOperateAddress(String operateAddress) {
        this.operateAddress = operateAddress == null ? null : operateAddress.trim();
    }

    /**
     * 获取入职时间(工薪类),时间戳
     *
     * @return hired_time - 入职时间(工薪类),时间戳
     */
    public Date getHiredTime() {
        return hiredTime;
    }

    /**
     * 设置入职时间(工薪类),时间戳
     *
     * @param hiredTime 入职时间(工薪类),时间戳
     */
    public void setHiredTime(Date hiredTime) {
        this.hiredTime = hiredTime;
    }

    /**
     * 获取入职职位(工薪类)
     *
     * @return station - 入职职位(工薪类)
     */
    public String getStation() {
        return station;
    }

    /**
     * 设置入职职位(工薪类)
     *
     * @param station 入职职位(工薪类)
     */
    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
    }

    /**
     * 获取薪水,单位：元(工薪类)，浮点数，保留2位
     *
     * @return wage - 薪水,单位：元(工薪类)，浮点数，保留2位
     */
    public Float getWage() {
        return wage;
    }

    /**
     * 设置薪水,单位：元(工薪类)，浮点数，保留2位
     *
     * @param wage 薪水,单位：元(工薪类)，浮点数，保留2位
     */
    public void setWage(Float wage) {
        this.wage = wage;
    }

    /**
     * 获取单位性质(工薪类)，详见字典说明
     *
     * @return unitType - 单位性质(工薪类)，详见字典说明
     */
    public Integer getUnittype() {
        return unittype;
    }

    /**
     * 设置单位性质(工薪类)，详见字典说明
     *
     * @param unittype 单位性质(工薪类)，详见字典说明
     */
    public void setUnittype(Integer unittype) {
        this.unittype = unittype;
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
        sb.append(", businessType=").append(businessType);
        sb.append(", companyName=").append(companyName);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", industryCode=").append(industryCode);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", monthTurnover=").append(monthTurnover);
        sb.append(", operateAddress=").append(operateAddress);
        sb.append(", hiredTime=").append(hiredTime);
        sb.append(", station=").append(station);
        sb.append(", wage=").append(wage);
        sb.append(", unittype=").append(unittype);
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