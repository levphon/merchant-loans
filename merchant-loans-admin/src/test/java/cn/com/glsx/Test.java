package cn.com.glsx;

import cn.com.payu.modules.loans.resp.PayGetBanklistResp;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHBsaWNhdGlvbiI6Im1sb2FucyIsInBob25lIjoiMTg2ODIxODU4NzYiLCJleHAiOjE1OTc0MTQ0OTYsImNsYXp6IjoiY24uY29tLnBheXUubW9kdWxlcy51c2VyLnV0aWxzLkp3dFVzZXIiLCJ1c2VySWQiOiIxIiwiand0SWQiOiI4OTVjZmMzMi1jODk5LTQ2NzUtOWRlZS0xNDUzNDhjMTRiYjgifQ.Q2pr3qS_RNbtKLB_RqPdaBpcrYsQ5RKyuiGLP8mL9v8";
        DecodedJWT jwt = JWT.decode(token);

        String algorithm = jwt.getAlgorithm();
        System.out.println(algorithm);

        Map<String, Claim> map =  jwt.getClaims();

        System.out.println(jwt.getPayload());
    }

    public static void aaa() {
        String json = "{\"code\":200,\"msg\":\"success\",\"data\":[{\"bankcode\":\"CITIC\",\"bankname\":\"中信银行\"},{\"bankcode\":\"ICBC\",\"bankname\":\"中国工商银行\"},{\"bankcode\":\"CCB\",\"bankname\":\"中国建设银行\"},{\"bankcode\":\"CMBC\",\"bankname\":\"中国民生银行\"},{\"bankcode\":\"CMB\",\"bankname\":\"招商银行\"},{\"bankcode\":\"CIB\",\"bankname\":\"兴业银行\"},{\"bankcode\":\"PAB\",\"bankname\":\"平安银行\"}]}";
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        PayGetBanklistResp resp = gson.fromJson(json, PayGetBanklistResp.class);
        System.out.println(resp);
    }

}
