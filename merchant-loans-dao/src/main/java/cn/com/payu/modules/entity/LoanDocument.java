package cn.com.payu.modules.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "d_loan_document")
public class LoanDocument implements Serializable {
    @Id
    private Long id;

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 身份证正面图片的链接
     */
    @Column(name = "id_card_front")
    private String idCardFront;

    /**
     * 身份证反面图片的链接
     */
    @Column(name = "id_card_back")
    private String idCardBack;

    /**
     * 信用报告的文件链接数组
     */
    @Column(name = "credit_report")
    private String creditReport;

    /**
     * 收入证明的文件链接数组
     */
    @Column(name = "income_proof")
    private String incomeProof;

    /**
     * 住址证明的文件链接数组)
     */
    @Column(name = "address_proof")
    private String addressProof;

    /**
     * 其他辅助资料的文件链接数组
     */
    @Column(name = "assist_material")
    private String assistMaterial;

    /**
     * 申请资料的文件链接数组
     */
    @Column(name = "apply_material")
    private String applyMaterial;

    /**
     * 签约视频的文件链接数组
     */
    @Column(name = "sign_video")
    private String signVideo;

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
     * 获取身份证正面图片的链接
     *
     * @return id_card_front - 身份证正面图片的链接
     */
    public String getIdCardFront() {
        return idCardFront;
    }

    /**
     * 设置身份证正面图片的链接
     *
     * @param idCardFront 身份证正面图片的链接
     */
    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront == null ? null : idCardFront.trim();
    }

    /**
     * 获取身份证反面图片的链接
     *
     * @return id_card_back - 身份证反面图片的链接
     */
    public String getIdCardBack() {
        return idCardBack;
    }

    /**
     * 设置身份证反面图片的链接
     *
     * @param idCardBack 身份证反面图片的链接
     */
    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack == null ? null : idCardBack.trim();
    }

    /**
     * 获取信用报告的文件链接数组
     *
     * @return credit_report - 信用报告的文件链接数组
     */
    public String getCreditReport() {
        return creditReport;
    }

    /**
     * 设置信用报告的文件链接数组
     *
     * @param creditReport 信用报告的文件链接数组
     */
    public void setCreditReport(String creditReport) {
        this.creditReport = creditReport == null ? null : creditReport.trim();
    }

    /**
     * 获取收入证明的文件链接数组
     *
     * @return income_proof - 收入证明的文件链接数组
     */
    public String getIncomeProof() {
        return incomeProof;
    }

    /**
     * 设置收入证明的文件链接数组
     *
     * @param incomeProof 收入证明的文件链接数组
     */
    public void setIncomeProof(String incomeProof) {
        this.incomeProof = incomeProof == null ? null : incomeProof.trim();
    }

    /**
     * 获取住址证明的文件链接数组)
     *
     * @return address_proof - 住址证明的文件链接数组)
     */
    public String getAddressProof() {
        return addressProof;
    }

    /**
     * 设置住址证明的文件链接数组)
     *
     * @param addressProof 住址证明的文件链接数组)
     */
    public void setAddressProof(String addressProof) {
        this.addressProof = addressProof == null ? null : addressProof.trim();
    }

    /**
     * 获取其他辅助资料的文件链接数组
     *
     * @return assist_material - 其他辅助资料的文件链接数组
     */
    public String getAssistMaterial() {
        return assistMaterial;
    }

    /**
     * 设置其他辅助资料的文件链接数组
     *
     * @param assistMaterial 其他辅助资料的文件链接数组
     */
    public void setAssistMaterial(String assistMaterial) {
        this.assistMaterial = assistMaterial == null ? null : assistMaterial.trim();
    }

    /**
     * 获取申请资料的文件链接数组
     *
     * @return apply_material - 申请资料的文件链接数组
     */
    public String getApplyMaterial() {
        return applyMaterial;
    }

    /**
     * 设置申请资料的文件链接数组
     *
     * @param applyMaterial 申请资料的文件链接数组
     */
    public void setApplyMaterial(String applyMaterial) {
        this.applyMaterial = applyMaterial == null ? null : applyMaterial.trim();
    }

    /**
     * 获取签约视频的文件链接数组
     *
     * @return sign_video - 签约视频的文件链接数组
     */
    public String getSignVideo() {
        return signVideo;
    }

    /**
     * 设置签约视频的文件链接数组
     *
     * @param signVideo 签约视频的文件链接数组
     */
    public void setSignVideo(String signVideo) {
        this.signVideo = signVideo == null ? null : signVideo.trim();
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
        sb.append(", idCardFront=").append(idCardFront);
        sb.append(", idCardBack=").append(idCardBack);
        sb.append(", creditReport=").append(creditReport);
        sb.append(", incomeProof=").append(incomeProof);
        sb.append(", addressProof=").append(addressProof);
        sb.append(", assistMaterial=").append(assistMaterial);
        sb.append(", applyMaterial=").append(applyMaterial);
        sb.append(", signVideo=").append(signVideo);
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