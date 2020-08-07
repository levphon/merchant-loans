package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayPretiedcardReq extends AbstractApiReq {

    @SerializedName("account_no")
    private String accountNo;//是	string	借记卡号

    @SerializedName("account_name")
    private String accountName;//是	string	开户姓名

    @SerializedName("idcard_no")
    private String idcardNo;//是	string	开户身份证号

    private String mobile;//是	string	预留手机号

    @SerializedName("order_number")
    private String orderNumber;//是	string	我方订单号

}
