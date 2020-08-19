package cn.com.payu.modules.loans.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ApplymentQueryPlansItem {

    private String id;

    @SerializedName("plan_periods_order")
    private Integer planPeriodsOrder;//还款期数

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @SerializedName("plan_repay_time")
    private Date planRepayTime;//应还日期（账单日），eg:2019-06-23

    @SerializedName("plan_repay_principal")
    private BigDecimal planRepayPrincipal;//应还本金

    @SerializedName("plan_repay_total")
    private BigDecimal planRepayTotal;//应还合计

    @SerializedName("plan_remain_principal")
    private BigDecimal planRemainPrincipal;//剩余本金

    @SerializedName("plan_status")
    private Integer planStatus;//还款状态：1尚未还清2已还清

}
