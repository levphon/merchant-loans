package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BasicsGetIndustryTypeListItem {

    /**
     * 一级行列类别ID(父类别)，默认为0：获取一级行列类别，若传递该字段则获取二级行列类别
     */
    @SerializedName("industry_id")
    private Integer industryId;

    @SerializedName("industry_name")
    private String industryName;

}
