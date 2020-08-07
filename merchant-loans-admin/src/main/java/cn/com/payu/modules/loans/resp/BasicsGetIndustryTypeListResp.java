package cn.com.payu.modules.loans.resp;

import lombok.Data;

import java.util.List;

@Data
public class BasicsGetIndustryTypeListResp extends AbstractApiResp {

    private List<BasicsGetIndustryTypeListItem> data;

}
