package cn.com.payu.modules.loans.resp;

import lombok.Data;

import java.util.Map;

@Data
public class BasicsGetUnitTypeListResp extends AbstractApiResp {

    private Map<String, String> data;

}
