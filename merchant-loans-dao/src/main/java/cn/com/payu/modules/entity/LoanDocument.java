package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_document")
public class LoanDocument extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 文件类型：
     * 1、身份证正面图片的链接
     * 2、身份证反面图片的链接
     * 3、信用报告的文件链接数组
     * 4、收入证明的文件链接数组
     * 5、住址证明的文件链接数组
     * 6、其他辅助资料的文件链接数组
     * 7、签约视频的文件链接数组
     */
    private Integer type;

    private String name;

    private String url;

//    /**
//     * 身份证正面图片的链接
//     */
//    @Column(name = "id_card_front")
//    private String idCardFront;
//
//    /**
//     * 身份证反面图片的链接
//     */
//    @Column(name = "id_card_back")
//    private String idCardBack;
//
//    /**
//     * 信用报告的文件链接数组
//     */
//    @Column(name = "credit_report")
//    private String creditReport;
//
//    /**
//     * 收入证明的文件链接数组
//     */
//    @Column(name = "income_proof")
//    private String incomeProof;
//
//    /**
//     * 住址证明的文件链接数组)
//     */
//    @Column(name = "address_proof")
//    private String addressProof;
//
//    /**
//     * 其他辅助资料的文件链接数组
//     */
//    @Column(name = "assist_material")
//    private String assistMaterial;
//
//    /**
//     * 申请资料的文件链接数组
//     */
//    @Column(name = "apply_material")
//    private String applyMaterial;
//
//    /**
//     * 签约视频的文件链接数组
//     */
//    @Column(name = "sign_video")
//    private String signVideo;

}