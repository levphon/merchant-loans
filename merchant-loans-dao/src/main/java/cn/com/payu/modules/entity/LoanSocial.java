package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_social")
public class LoanSocial implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 现投保单位
     */
    @Column(name = "insured_address")
    private String insuredAddress;

    /**
     * 现投保时长(单位：月)
     */
    @Column(name = "insured_day")
    private Integer insuredDay;

    /**
     * 原投保单位
     */
    @Column(name = "old_address")
    private String oldAddress;

    /**
     * 投保工资标准(单位：元），浮点数，保留2位
     */
    @Column(name = "insured_standard")
    private Float insuredStandard;

    /**
     * 查询时间，时间戳
     */
    @Column(name = "get_social_time")
    private Date getSocialTime;

    /**
     * 养老金余额(单位：元），浮点数，保留2位
     */
    private Float annuity;

    /**
     * 医疗保险余额(单位：元），浮点数，保留2位
     */
    private Float medical;

    /**
     * 最早投保时间,时间戳
     */
    @Column(name = "earliest_date")
    private Date earliestDate;

    /**
     * 近三个月投保状态 1正常0不正常
     */
    @Column(name = "lately_status")
    private Integer latelyStatus;

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
     * 获取现投保单位
     *
     * @return insured_address - 现投保单位
     */
    public String getInsuredAddress() {
        return insuredAddress;
    }

    /**
     * 设置现投保单位
     *
     * @param insuredAddress 现投保单位
     */
    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress == null ? null : insuredAddress.trim();
    }

    /**
     * 获取现投保时长(单位：月)
     *
     * @return insured_day - 现投保时长(单位：月)
     */
    public Integer getInsuredDay() {
        return insuredDay;
    }

    /**
     * 设置现投保时长(单位：月)
     *
     * @param insuredDay 现投保时长(单位：月)
     */
    public void setInsuredDay(Integer insuredDay) {
        this.insuredDay = insuredDay;
    }

    /**
     * 获取原投保单位
     *
     * @return old_address - 原投保单位
     */
    public String getOldAddress() {
        return oldAddress;
    }

    /**
     * 设置原投保单位
     *
     * @param oldAddress 原投保单位
     */
    public void setOldAddress(String oldAddress) {
        this.oldAddress = oldAddress == null ? null : oldAddress.trim();
    }

    /**
     * 获取投保工资标准(单位：元），浮点数，保留2位
     *
     * @return insured_standard - 投保工资标准(单位：元），浮点数，保留2位
     */
    public Float getInsuredStandard() {
        return insuredStandard;
    }

    /**
     * 设置投保工资标准(单位：元），浮点数，保留2位
     *
     * @param insuredStandard 投保工资标准(单位：元），浮点数，保留2位
     */
    public void setInsuredStandard(Float insuredStandard) {
        this.insuredStandard = insuredStandard;
    }

    /**
     * 获取查询时间，时间戳
     *
     * @return get_social_time - 查询时间，时间戳
     */
    public Date getGetSocialTime() {
        return getSocialTime;
    }

    /**
     * 设置查询时间，时间戳
     *
     * @param getSocialTime 查询时间，时间戳
     */
    public void setGetSocialTime(Date getSocialTime) {
        this.getSocialTime = getSocialTime;
    }

    /**
     * 获取养老金余额(单位：元），浮点数，保留2位
     *
     * @return annuity - 养老金余额(单位：元），浮点数，保留2位
     */
    public Float getAnnuity() {
        return annuity;
    }

    /**
     * 设置养老金余额(单位：元），浮点数，保留2位
     *
     * @param annuity 养老金余额(单位：元），浮点数，保留2位
     */
    public void setAnnuity(Float annuity) {
        this.annuity = annuity;
    }

    /**
     * 获取医疗保险余额(单位：元），浮点数，保留2位
     *
     * @return medical - 医疗保险余额(单位：元），浮点数，保留2位
     */
    public Float getMedical() {
        return medical;
    }

    /**
     * 设置医疗保险余额(单位：元），浮点数，保留2位
     *
     * @param medical 医疗保险余额(单位：元），浮点数，保留2位
     */
    public void setMedical(Float medical) {
        this.medical = medical;
    }

    /**
     * 获取最早投保时间,时间戳
     *
     * @return earliest_date - 最早投保时间,时间戳
     */
    public Date getEarliestDate() {
        return earliestDate;
    }

    /**
     * 设置最早投保时间,时间戳
     *
     * @param earliestDate 最早投保时间,时间戳
     */
    public void setEarliestDate(Date earliestDate) {
        this.earliestDate = earliestDate;
    }

    /**
     * 获取近三个月投保状态 1正常0不正常
     *
     * @return lately_status - 近三个月投保状态 1正常0不正常
     */
    public Integer getLatelyStatus() {
        return latelyStatus;
    }

    /**
     * 设置近三个月投保状态 1正常0不正常
     *
     * @param latelyStatus 近三个月投保状态 1正常0不正常
     */
    public void setLatelyStatus(Integer latelyStatus) {
        this.latelyStatus = latelyStatus;
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
        sb.append(", insuredAddress=").append(insuredAddress);
        sb.append(", insuredDay=").append(insuredDay);
        sb.append(", oldAddress=").append(oldAddress);
        sb.append(", insuredStandard=").append(insuredStandard);
        sb.append(", getSocialTime=").append(getSocialTime);
        sb.append(", annuity=").append(annuity);
        sb.append(", medical=").append(medical);
        sb.append(", earliestDate=").append(earliestDate);
        sb.append(", latelyStatus=").append(latelyStatus);
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