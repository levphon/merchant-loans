package cn.com.payu.modules.loans.resp;

import lombok.Data;

@Data
public abstract class AbstractApiResp {

    private String code;
    private String msg;

}
