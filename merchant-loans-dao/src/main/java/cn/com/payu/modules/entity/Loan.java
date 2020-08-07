package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan")
public class Loan implements Serializable {
    @Id
    private Long id;

    /**
     * 商户订单号
     */
    @Column(name = "order_number")
    private String orderNumber;

    /**
     * 贷款产品id，我方提供
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 客户贷款金额(单位：元)
     */
    private Integer annuity;

    /**
     * 客户贷款用途，详见字典说明
     */
    @Column(name = "loan_purpose")
    private Integer loanPurpose;

    /**
     * 客户申请期限，详见字典说明
     */
    @Column(name = "loan_period")
    private Integer loanPeriod;

    /**
     * 建议费率，保留两位小数，默认为：0
     */
    @Column(name = "merchant_rate")
    private Float merchantRate;

    /**
     * 还款方式，详见字典说明，默认为：2
     */
    @Column(name = "pay_method")
    private Integer payMethod;

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
     * 获取商户订单号
     *
     * @return order_number - 商户订单号
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * 设置商户订单号
     *
     * @param orderNumber 商户订单号
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    /**
     * 获取贷款产品id，我方提供
     *
     * @return product_id - 贷款产品id，我方提供
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置贷款产品id，我方提供
     *
     * @param productId 贷款产品id，我方提供
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取客户贷款金额(单位：元)
     *
     * @return annuity - 客户贷款金额(单位：元)
     */
    public Integer getAnnuity() {
        return annuity;
    }

    /**
     * 设置客户贷款金额(单位：元)
     *
     * @param annuity 客户贷款金额(单位：元)
     */
    public void setAnnuity(Integer annuity) {
        this.annuity = annuity;
    }

    /**
     * 获取客户贷款用途，详见字典说明
     *
     * @return loan_purpose - 客户贷款用途，详见字典说明
     */
    public Integer getLoanPurpose() {
        return loanPurpose;
    }

    /**
     * 设置客户贷款用途，详见字典说明
     *
     * @param loanPurpose 客户贷款用途，详见字典说明
     */
    public void setLoanPurpose(Integer loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    /**
     * 获取客户申请期限，详见字典说明
     *
     * @return loan_period - 客户申请期限，详见字典说明
     */
    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * 设置客户申请期限，详见字典说明
     *
     * @param loanPeriod 客户申请期限，详见字典说明
     */
    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * 获取建议费率，保留两位小数，默认为：0
     *
     * @return merchant_rate - 建议费率，保留两位小数，默认为：0
     */
    public Float getMerchantRate() {
        return merchantRate;
    }

    /**
     * 设置建议费率，保留两位小数，默认为：0
     *
     * @param merchantRate 建议费率，保留两位小数，默认为：0
     */
    public void setMerchantRate(Float merchantRate) {
        this.merchantRate = merchantRate;
    }

    /**
     * 获取还款方式，详见字典说明，默认为：2
     *
     * @return pay_method - 还款方式，详见字典说明，默认为：2
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置还款方式，详见字典说明，默认为：2
     *
     * @param payMethod 还款方式，详见字典说明，默认为：2
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
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
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", productId=").append(productId);
        sb.append(", annuity=").append(annuity);
        sb.append(", loanPurpose=").append(loanPurpose);
        sb.append(", loanPeriod=").append(loanPeriod);
        sb.append(", merchantRate=").append(merchantRate);
        sb.append(", payMethod=").append(payMethod);
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