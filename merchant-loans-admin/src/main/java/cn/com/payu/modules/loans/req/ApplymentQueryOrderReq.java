package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ApplymentQueryOrderReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//	是	string	32	商户订单号或者我方订单号

}
