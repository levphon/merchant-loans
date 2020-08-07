package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayGetPayInfoReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//	是	string	我方订单号

    @SerializedName("repay_type")
    private String repayType;//	是	string	还款类型:提前还款(advance),正常还款( normal), 逾期还款(overdue)

}
