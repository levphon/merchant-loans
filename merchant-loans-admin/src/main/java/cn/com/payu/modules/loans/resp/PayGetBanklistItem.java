package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayGetBanklistItem {

    /**
     * 银行编码
     */
    @SerializedName("bankcode")
    private String bankCode;

    /**
     * 银行名称
     */
    @SerializedName("bankname")
    private String bankName;

}
