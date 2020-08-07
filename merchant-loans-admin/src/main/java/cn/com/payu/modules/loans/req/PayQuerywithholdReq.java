package cn.com.payu.modules.loans.req;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayQuerywithholdReq extends AbstractApiReq {

    @SerializedName("trade_number")
    private String tradeNumber;//	是	string	代扣交易编号，此为代扣操作返回的流水号

}
