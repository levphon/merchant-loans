package cn.com.payu.modules.loans.resp;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ApplymentQueryPlansRespData {

    @SerializedName("plan_list")
    private List<List<ApplymentQueryPlansItem>> planList;

}
