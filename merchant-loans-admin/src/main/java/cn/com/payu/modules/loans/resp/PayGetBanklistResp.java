package cn.com.payu.modules.loans.resp;

import lombok.Data;

import java.util.List;

@Data
public class PayGetBanklistResp extends AbstractApiResp {

    private List<PayGetBanklistItem> data;

}
