package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "d_loan_contract")
public class LoanContract extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 合同名称
     */
    private String name;

    /**
     * 签约文件路径
     */
    @Column(name = "sign_pdf_src")
    private String signPdfSrc;

    /**
     * 签署源文件
     */
    @Column(name = "pdf_src")
    private String pdfSrc;

    /**
     * 合同签署时间
     */
    @Column(name = "sign_time")
    private Date signTime;

    /**
     * 签署状态 1未签署 2已签署
     */
    private Integer status;

}