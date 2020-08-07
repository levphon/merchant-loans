package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EsignMycontractReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//	是	string	32	借款单号

}
