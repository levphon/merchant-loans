package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayConfirmbindcardReq extends AbstractApiReq {

    @SerializedName("account_no")
    private String accountNo;//是	string	借记卡号

    @SerializedName("account_name")
    private String accountName;//是	string	开户姓名

    @SerializedName("idcard_no")
    private String idcardNo;//是	string	开户身份证号

    @SerializedName("branch_name")
    private String branchName;//是	string	开户行分行名称

    private String mobile;//是	string	预留手机号

    @SerializedName("unique_code")
    private String uniqueCode;//是	string	绑卡鉴权认证码

    @SerializedName("sms_code")
    private String smsCode;//是	string	绑定银行卡短信验证码

    @SerializedName("order_number")
    private String orderNumber;//是	string	我方订单号

}
