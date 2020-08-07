package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_contact")
public class LoanContact implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 联系人名字
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系人和客户的关系，详见字典说明
     */
    private Integer relation;

    /**
     * 身份证号
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 联系电话
     */
    @Column(name = "contact_number")
    private String contactNumber;

    /**
     * 工作单位
     */
    @Column(name = "work_unit")
    private String workUnit;

    /**
     * 单位地址
     */
    @Column(name = "unit_address")
    private String unitAddress;

    /**
     * 现地址
     */
    @Column(name = "contact_address")
    private String contactAddress;

    /**
     * 知晓贷款，详见字典说明
     */
    @Column(name = "is_know")
    private Integer isKnow;

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
     * 获取联系人名字
     *
     * @return contact_name - 联系人名字
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人名字
     *
     * @param contactName 联系人名字
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取联系人和客户的关系，详见字典说明
     *
     * @return relation - 联系人和客户的关系，详见字典说明
     */
    public Integer getRelation() {
        return relation;
    }

    /**
     * 设置联系人和客户的关系，详见字典说明
     *
     * @param relation 联系人和客户的关系，详见字典说明
     */
    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    /**
     * 获取身份证号
     *
     * @return id_number - 身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号
     *
     * @param idNumber 身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取联系电话
     *
     * @return contact_number - 联系电话
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 设置联系电话
     *
     * @param contactNumber 联系电话
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    /**
     * 获取工作单位
     *
     * @return work_unit - 工作单位
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * 设置工作单位
     *
     * @param workUnit 工作单位
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit == null ? null : workUnit.trim();
    }

    /**
     * 获取单位地址
     *
     * @return unit_address - 单位地址
     */
    public String getUnitAddress() {
        return unitAddress;
    }

    /**
     * 设置单位地址
     *
     * @param unitAddress 单位地址
     */
    public void setUnitAddress(String unitAddress) {
        this.unitAddress = unitAddress == null ? null : unitAddress.trim();
    }

    /**
     * 获取现地址
     *
     * @return contact_address - 现地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置现地址
     *
     * @param contactAddress 现地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    /**
     * 获取知晓贷款，详见字典说明
     *
     * @return is_know - 知晓贷款，详见字典说明
     */
    public Integer getIsKnow() {
        return isKnow;
    }

    /**
     * 设置知晓贷款，详见字典说明
     *
     * @param isKnow 知晓贷款，详见字典说明
     */
    public void setIsKnow(Integer isKnow) {
        this.isKnow = isKnow;
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
        sb.append(", contactName=").append(contactName);
        sb.append(", relation=").append(relation);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", workUnit=").append(workUnit);
        sb.append(", unitAddress=").append(unitAddress);
        sb.append(", contactAddress=").append(contactAddress);
        sb.append(", isKnow=").append(isKnow);
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