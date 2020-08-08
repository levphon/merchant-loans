package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class EsignMycontractRespData {

    @SerializedName("status_des")
    private String statusDes;//单据状态

    @SerializedName("order_number")
    private String orderNumber;//单据编号

    private List<EsignMycontractItem> contract;

}
