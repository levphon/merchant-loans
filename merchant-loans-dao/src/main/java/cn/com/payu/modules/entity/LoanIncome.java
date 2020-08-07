package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_income")
public class LoanIncome implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 流水类型 1：对私银行流水信息,2：对公银行流水信息
     */
    @Column(name = "income_type")
    private Integer incomeType;

    /**
     * 近1个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_one_month")
    private Float nearlyOneMonth;

    /**
     * 近2个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_two_month")
    private Float nearlyTwoMonth;

    /**
     * 近3个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_third_month")
    private Float nearlyThirdMonth;

    /**
     * 近4个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_four_month")
    private Float nearlyFourMonth;

    /**
     * 近5个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_five_month")
    private Float nearlyFiveMonth;

    /**
     * 近6个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_six_month")
    private Float nearlySixMonth;

    /**
     * 结息金额(单位：元)，浮点数，保留2位
     */
    @Column(name = "interest_amount")
    private Float interestAmount;

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
     * 获取流水类型 1：对私银行流水信息,2：对公银行流水信息
     *
     * @return income_type - 流水类型 1：对私银行流水信息,2：对公银行流水信息
     */
    public Integer getIncomeType() {
        return incomeType;
    }

    /**
     * 设置流水类型 1：对私银行流水信息,2：对公银行流水信息
     *
     * @param incomeType 流水类型 1：对私银行流水信息,2：对公银行流水信息
     */
    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * 获取近1个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_one_month - 近1个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlyOneMonth() {
        return nearlyOneMonth;
    }

    /**
     * 设置近1个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlyOneMonth 近1个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlyOneMonth(Float nearlyOneMonth) {
        this.nearlyOneMonth = nearlyOneMonth;
    }

    /**
     * 获取近2个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_two_month - 近2个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlyTwoMonth() {
        return nearlyTwoMonth;
    }

    /**
     * 设置近2个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlyTwoMonth 近2个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlyTwoMonth(Float nearlyTwoMonth) {
        this.nearlyTwoMonth = nearlyTwoMonth;
    }

    /**
     * 获取近3个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_third_month - 近3个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlyThirdMonth() {
        return nearlyThirdMonth;
    }

    /**
     * 设置近3个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlyThirdMonth 近3个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlyThirdMonth(Float nearlyThirdMonth) {
        this.nearlyThirdMonth = nearlyThirdMonth;
    }

    /**
     * 获取近4个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_four_month - 近4个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlyFourMonth() {
        return nearlyFourMonth;
    }

    /**
     * 设置近4个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlyFourMonth 近4个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlyFourMonth(Float nearlyFourMonth) {
        this.nearlyFourMonth = nearlyFourMonth;
    }

    /**
     * 获取近5个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_five_month - 近5个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlyFiveMonth() {
        return nearlyFiveMonth;
    }

    /**
     * 设置近5个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlyFiveMonth 近5个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlyFiveMonth(Float nearlyFiveMonth) {
        this.nearlyFiveMonth = nearlyFiveMonth;
    }

    /**
     * 获取近6个月流水(单位：元)，浮点数，保留2位
     *
     * @return nearly_six_month - 近6个月流水(单位：元)，浮点数，保留2位
     */
    public Float getNearlySixMonth() {
        return nearlySixMonth;
    }

    /**
     * 设置近6个月流水(单位：元)，浮点数，保留2位
     *
     * @param nearlySixMonth 近6个月流水(单位：元)，浮点数，保留2位
     */
    public void setNearlySixMonth(Float nearlySixMonth) {
        this.nearlySixMonth = nearlySixMonth;
    }

    /**
     * 获取结息金额(单位：元)，浮点数，保留2位
     *
     * @return interest_amount - 结息金额(单位：元)，浮点数，保留2位
     */
    public Float getInterestAmount() {
        return interestAmount;
    }

    /**
     * 设置结息金额(单位：元)，浮点数，保留2位
     *
     * @param interestAmount 结息金额(单位：元)，浮点数，保留2位
     */
    public void setInterestAmount(Float interestAmount) {
        this.interestAmount = interestAmount;
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
        sb.append(", incomeType=").append(incomeType);
        sb.append(", nearlyOneMonth=").append(nearlyOneMonth);
        sb.append(", nearlyTwoMonth=").append(nearlyTwoMonth);
        sb.append(", nearlyThirdMonth=").append(nearlyThirdMonth);
        sb.append(", nearlyFourMonth=").append(nearlyFourMonth);
        sb.append(", nearlyFiveMonth=").append(nearlyFiveMonth);
        sb.append(", nearlySixMonth=").append(nearlySixMonth);
        sb.append(", interestAmount=").append(interestAmount);
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