package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasicsGetLoansProductsItem {

    @SerializedName("product_id")
    private Integer productId;//贷款产品id，客户申请贷款，传递该字段值给我方

    @SerializedName("product_name")
    private String productName;//产品名称

    @SerializedName("min_amount")
    private BigDecimal minAmount;//最低额度(单位：万元)

    @SerializedName("max_amount")
    private BigDecimal maxAmount;//最大额度(单位：万元)

    @SerializedName("min_period")
    private Integer minPeriod;//最少还款期数(单位：月)

}
