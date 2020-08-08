package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentRejectReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//是	string	32	我方订单号
    private String reason;//是	string	200	驳回原因
    private BigDecimal annuity;//是	int	10	申请金额
    private Integer loanPeriod;//是	int	10	申请期限

}
