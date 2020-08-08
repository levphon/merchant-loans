package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApplymentQueryOrderRespData {

    private String orderNumber;//商户订单号

    private String applyNumber;//我方订单号

    @SerializedName("approval_amount")
    private String approvalAmount;//审批金额

    @SerializedName("approval_period")
    private String approvalPeriod;//审批期限

    @SerializedName("approval_status")
    private String approvalStatus;//状态，详见字典说明

    @SerializedName("approval_push_time")
    private String approvalPushTime;//进件时间，时间戳

    @SerializedName("backout_reason")
    private String backoutReason;//撤销原因

    @SerializedName("abandon_reason")
    private String abandonReason;//作废原因

}
