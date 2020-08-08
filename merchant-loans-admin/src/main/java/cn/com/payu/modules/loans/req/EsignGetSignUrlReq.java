package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EsignGetSignUrlReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//	是	string	32	商户订单号

    @SerializedName("sign_type")
    private Integer signType;//	是	int	1	签署地址类型： 1授权书 2借款合同

}
