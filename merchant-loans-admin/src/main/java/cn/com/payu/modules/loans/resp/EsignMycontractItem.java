package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EsignMycontractItem {

    @SerializedName("contract_name")
    private String contractName;//诺德小贷贷款合同

    @SerializedName("sign_pdf_src")
    private String signPdfSrc;//签约文件路径

    @SerializedName("sign_time")
    private String signTime;//该合同签署时间

    @SerializedName("status")
    private Integer status;//签署状态 1未签署 2已签署

    @SerializedName("pdf_src")
    private String pdfSrc;//签署源文件

}
