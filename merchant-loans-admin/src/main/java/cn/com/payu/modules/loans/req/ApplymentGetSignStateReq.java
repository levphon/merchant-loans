package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentGetSignStateReq extends AbstractApiReq {

    private String orderNumber;//	是	string	32	商户订单号

}
