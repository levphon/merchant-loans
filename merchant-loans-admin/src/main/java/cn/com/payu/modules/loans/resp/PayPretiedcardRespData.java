package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayPretiedcardRespData {

    /**
     * 绑卡鉴权认证码
     */
    private String uniqueCode;

    @SerializedName("user_id")
    private String userId;

}
