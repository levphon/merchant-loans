package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class EsignSigncontractRespData {

    @SerializedName("short_url")
    private String shortUrl;//短链地址，30天有效
    private String url;//长链地址(永久有效)

}
