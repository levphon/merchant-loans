package cn.com.payu.modules.loans.resp;

import lombok.Data;

import java.util.Map;

@Data
public class BasicsGetHousingTypesResp extends AbstractApiResp {

    private Map<String, String> data;

}
