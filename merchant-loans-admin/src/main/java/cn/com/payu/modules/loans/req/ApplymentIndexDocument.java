package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexDocument {

    /**
     * 身份证正面图片的链接
     */
    private String idCardFront;

    /**
     * 身份证反面图片的链接
     */
    private String idCardBack;

    /**
     * 信用报告的文件链接数组
     */
    private String creditReport;

    /**
     * 收入证明的文件链接数组
     */
    private String incomeProof;

    /**
     * 住址证明的文件链接数组
     */
    private String addressProof;

    /**
     * 其他辅助资料的文件链接数组
     */
    private String assistMaterial;

    /**
     * 申请资料的文件链接数组
     */
    private String applyMaterial;

    /**
     * 签约视频的文件链接数组
     */
    private String signVideo;

}
