package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EsignSigncontractReq extends AbstractApiReq {

    @SerializedName("order_number")
    private String orderNumber;//	是	string	32	我方订单号

    @SerializedName("notice_type")
    private String noticeType;//	是	string	1	签约模式：1-短信验证，2-签署地址，默认为：1

}
