package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_customer_bankcard")
public class CustomerBankcard implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 开户姓名
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * 借记卡号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 开户身份证号
     */
    @Column(name = "idcard_no")
    private String idcardNo;

    /**
     * 预留手机号
     */
    private String mobile;

    /**
     * 开户行
     */
    @Column(name = "bank_code")
    private String bankCode;

    /**
     * 开户分行
     */
    @Column(name = "branch_name")
    private String branchName;

    /**
     * 绑定通道：如宝付、快付通、银联等,暂时无用
     */
    @Column(name = "bind_channel")
    private Integer bindChannel;

    /**
     * 绑定状态
     */
    @Column(name = "bind_status")
    private Integer bindStatus;

    /**
     * 绑卡鉴权认证码
     */
    @Column(name = "unique_code")
    private String uniqueCode;

    /**
     * 使用状态
     */
    @Column(name = "use_status")
    private Integer useStatus;

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
     * 获取开户姓名
     *
     * @return account_name - 开户姓名
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置开户姓名
     *
     * @param accountName 开户姓名
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * 获取借记卡号
     *
     * @return account_no - 借记卡号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置借记卡号
     *
     * @param accountNo 借记卡号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * 获取开户身份证号
     *
     * @return idcard_no - 开户身份证号
     */
    public String getIdcardNo() {
        return idcardNo;
    }

    /**
     * 设置开户身份证号
     *
     * @param idcardNo 开户身份证号
     */
    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    /**
     * 获取预留手机号
     *
     * @return mobile - 预留手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置预留手机号
     *
     * @param mobile 预留手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取开户行
     *
     * @return bank_code - 开户行
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 设置开户行
     *
     * @param bankCode 开户行
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    /**
     * 获取开户分行
     *
     * @return branch_name - 开户分行
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * 设置开户分行
     *
     * @param branchName 开户分行
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    /**
     * 获取绑定通道：如宝付、快付通、银联等,暂时无用
     *
     * @return bind_channel - 绑定通道：如宝付、快付通、银联等,暂时无用
     */
    public Integer getBindChannel() {
        return bindChannel;
    }

    /**
     * 设置绑定通道：如宝付、快付通、银联等,暂时无用
     *
     * @param bindChannel 绑定通道：如宝付、快付通、银联等,暂时无用
     */
    public void setBindChannel(Integer bindChannel) {
        this.bindChannel = bindChannel;
    }

    /**
     * 获取绑定状态
     *
     * @return bind_status - 绑定状态
     */
    public Integer getBindStatus() {
        return bindStatus;
    }

    /**
     * 设置绑定状态
     *
     * @param bindStatus 绑定状态
     */
    public void setBindStatus(Integer bindStatus) {
        this.bindStatus = bindStatus;
    }

    /**
     * 获取绑卡鉴权认证码
     *
     * @return unique_code - 绑卡鉴权认证码
     */
    public String getUniqueCode() {
        return uniqueCode;
    }

    /**
     * 设置绑卡鉴权认证码
     *
     * @param uniqueCode 绑卡鉴权认证码
     */
    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode == null ? null : uniqueCode.trim();
    }

    /**
     * 获取使用状态
     *
     * @return use_status - 使用状态
     */
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
     * 设置使用状态
     *
     * @param useStatus 使用状态
     */
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
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
        sb.append(", accountName=").append(accountName);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", idcardNo=").append(idcardNo);
        sb.append(", mobile=").append(mobile);
        sb.append(", bankCode=").append(bankCode);
        sb.append(", branchName=").append(branchName);
        sb.append(", bindChannel=").append(bindChannel);
        sb.append(", bindStatus=").append(bindStatus);
        sb.append(", uniqueCode=").append(uniqueCode);
        sb.append(", useStatus=").append(useStatus);
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