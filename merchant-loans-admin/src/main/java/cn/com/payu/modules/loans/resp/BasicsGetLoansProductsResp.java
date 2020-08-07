package cn.com.payu.modules.loans.resp;

import lombok.Data;

import java.util.List;

@Data
public class BasicsGetLoansProductsResp extends AbstractApiResp {

    private List<BasicsGetLoansProductsItem> data;

}
