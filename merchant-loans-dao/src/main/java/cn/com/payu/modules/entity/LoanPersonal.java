package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_personal")
public class LoanPersonal implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 客户名称(必须中文，2-20个汉字)
     */
    private String name;

    /**
     * 性别，详见字典说明
     */
    private Integer gender;

    /**
     * 证件类型，默认为1，详见字典说明
     */
    @Column(name = "certificate_type")
    private Integer certificateType;

    /**
     * 证件号(比如身份证号)
     */
    @Column(name = "certificate_number")
    private String certificateNumber;

    /**
     * 证件到期日期，时间戳
     */
    @Column(name = "certificate_expiryDate")
    private Date certificateExpirydate;

    /**
     * 证件发证机关
     */
    private String institution;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最高学历，详见字典说明
     */
    @Column(name = "education_info")
    private Integer educationInfo;

    /**
     * 婚姻状态，详见字典说明
     */
    @Column(name = "marriage_info")
    private Integer marriageInfo;

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
     * 获取客户名称(必须中文，2-20个汉字)
     *
     * @return name - 客户名称(必须中文，2-20个汉字)
     */
    public String getName() {
        return name;
    }

    /**
     * 设置客户名称(必须中文，2-20个汉字)
     *
     * @param name 客户名称(必须中文，2-20个汉字)
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取性别，详见字典说明
     *
     * @return gender - 性别，详见字典说明
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别，详见字典说明
     *
     * @param gender 性别，详见字典说明
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取证件类型，默认为1，详见字典说明
     *
     * @return certificate_type - 证件类型，默认为1，详见字典说明
     */
    public Integer getCertificateType() {
        return certificateType;
    }

    /**
     * 设置证件类型，默认为1，详见字典说明
     *
     * @param certificateType 证件类型，默认为1，详见字典说明
     */
    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    /**
     * 获取证件号(比如身份证号)
     *
     * @return certificate_number - 证件号(比如身份证号)
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * 设置证件号(比如身份证号)
     *
     * @param certificateNumber 证件号(比如身份证号)
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
    }

    /**
     * 获取证件到期日期，时间戳
     *
     * @return certificate_expiryDate - 证件到期日期，时间戳
     */
    public Date getCertificateExpirydate() {
        return certificateExpirydate;
    }

    /**
     * 设置证件到期日期，时间戳
     *
     * @param certificateExpirydate 证件到期日期，时间戳
     */
    public void setCertificateExpirydate(Date certificateExpirydate) {
        this.certificateExpirydate = certificateExpirydate;
    }

    /**
     * 获取证件发证机关
     *
     * @return institution - 证件发证机关
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 设置证件发证机关
     *
     * @param institution 证件发证机关
     */
    public void setInstitution(String institution) {
        this.institution = institution == null ? null : institution.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取最高学历，详见字典说明
     *
     * @return education_info - 最高学历，详见字典说明
     */
    public Integer getEducationInfo() {
        return educationInfo;
    }

    /**
     * 设置最高学历，详见字典说明
     *
     * @param educationInfo 最高学历，详见字典说明
     */
    public void setEducationInfo(Integer educationInfo) {
        this.educationInfo = educationInfo;
    }

    /**
     * 获取婚姻状态，详见字典说明
     *
     * @return marriage_info - 婚姻状态，详见字典说明
     */
    public Integer getMarriageInfo() {
        return marriageInfo;
    }

    /**
     * 设置婚姻状态，详见字典说明
     *
     * @param marriageInfo 婚姻状态，详见字典说明
     */
    public void setMarriageInfo(Integer marriageInfo) {
        this.marriageInfo = marriageInfo;
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
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", certificateType=").append(certificateType);
        sb.append(", certificateNumber=").append(certificateNumber);
        sb.append(", certificateExpirydate=").append(certificateExpirydate);
        sb.append(", institution=").append(institution);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", email=").append(email);
        sb.append(", educationInfo=").append(educationInfo);
        sb.append(", marriageInfo=").append(marriageInfo);
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