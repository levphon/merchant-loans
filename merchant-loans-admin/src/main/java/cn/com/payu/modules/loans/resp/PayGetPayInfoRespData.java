package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayGetPayInfoRespData {

    @SerializedName("balance_principal")
    private BigDecimal balancePrincipal;//应还本金

    @SerializedName("balance_total")
    private BigDecimal balanceTotal;//应还总计

    @SerializedName("balance_interest")
    private BigDecimal balanceInterest;//应还利息

    @SerializedName("balance_overdue")
    private BigDecimal balanceOverdue;//应还滞纳金

    @SerializedName("balance_penalty")
    private BigDecimal balancePenalty;//应还违约金

    @SerializedName("balance_fail_fee")
    private BigDecimal balanceFailFee;//逾期的扣款失败手续费

}
