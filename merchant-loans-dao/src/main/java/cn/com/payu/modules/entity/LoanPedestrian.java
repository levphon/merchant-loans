package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_pedestrian")
public class LoanPedestrian implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 人行征信的账号
     */
    private String account;

    /**
     * 人行征信的密码
     */
    private String password;

    /**
     * 人行征信的授权码
     */
    @Column(name = "authorization_code")
    private String authorizationCode;

    /**
     * 有效期，时间戳
     */
    @Column(name = "expired_time")
    private Date expiredTime;

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
     * 获取人行征信的账号
     *
     * @return account - 人行征信的账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置人行征信的账号
     *
     * @param account 人行征信的账号
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 获取人行征信的密码
     *
     * @return password - 人行征信的密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置人行征信的密码
     *
     * @param password 人行征信的密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取人行征信的授权码
     *
     * @return authorization_code - 人行征信的授权码
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * 设置人行征信的授权码
     *
     * @param authorizationCode 人行征信的授权码
     */
    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode == null ? null : authorizationCode.trim();
    }

    /**
     * 获取有效期，时间戳
     *
     * @return expired_time - 有效期，时间戳
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * 设置有效期，时间戳
     *
     * @param expiredTime 有效期，时间戳
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
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
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", authorizationCode=").append(authorizationCode);
        sb.append(", expiredTime=").append(expiredTime);
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