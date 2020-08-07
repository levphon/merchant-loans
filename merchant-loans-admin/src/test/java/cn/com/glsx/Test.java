package cn.com.glsx;

import cn.com.payu.modules.loans.resp.PayGetBanklistResp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {

    public static void main(String[] args) {
        String json = "{\"code\":200,\"msg\":\"success\",\"data\":[{\"bankcode\":\"CITIC\",\"bankname\":\"中信银行\"},{\"bankcode\":\"ICBC\",\"bankname\":\"中国工商银行\"},{\"bankcode\":\"CCB\",\"bankname\":\"中国建设银行\"},{\"bankcode\":\"CMBC\",\"bankname\":\"中国民生银行\"},{\"bankcode\":\"CMB\",\"bankname\":\"招商银行\"},{\"bankcode\":\"CIB\",\"bankname\":\"兴业银行\"},{\"bankcode\":\"PAB\",\"bankname\":\"平安银行\"}]}";
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        PayGetBanklistResp resp = gson.fromJson(json, PayGetBanklistResp.class);
        System.out.println(resp);
    }

}
