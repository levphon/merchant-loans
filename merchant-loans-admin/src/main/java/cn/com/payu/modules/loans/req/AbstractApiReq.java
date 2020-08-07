package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public abstract class AbstractApiReq {

    /**
     * 商户号
     */
    @SerializedName("mer_id")
    private String merId;

    /**
     * 签名
     */
    private String sign;

}
