package cn.com.payu.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.glsx.plat.common.utils.HttpUtils;
import com.glsx.plat.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.TreeMap;

/**
 * 短信工具类
 */
@Slf4j
@Component("smsUtil")
public class SmsUtils {

    @Resource
    private SMSProperties properties;

    /**
     * 短信
     *
     * @param phone
     * @param content
     */
    @Async
    public void send(String phone, String content) {
        send(phone, content, properties.getSource());
    }

    /**
     * 短信派单
     *
     * @param phone
     * @param content
     * @param source
     */
    @Async
    public void send(String phone, String content, String source) {

        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("method", "glsx.message.sendmessage");
        treeMap.put("format", "json");
        treeMap.put("akey", "9c991f5abac812b7a2739beecde2fdc7");
        treeMap.put("v", "1.0.0");
        treeMap.put("channel", "1001");
        treeMap.put("lock", "2AC16F3AB37C129E273A4979FD0A46B0");

        treeMap.put("source", source);
        treeMap.put("type", "1");
        treeMap.put("phone", phone);
        treeMap.put("content", content);
        treeMap.put("subcode", "");

        log.info("Send Sms:" + treeMap.toString());

        String url = properties.getUrl();
//        String url = "http://192.168.3.206:8118/router";//开发
//        String url = "http://qcdidicb.glsx.net:7060/router";//测试（貌似已经废弃了）
//        String url = "http://qcapp.oss.glsx.net:7060/gop-message/router";//测试

        log.info("短信接口：" + url);

        HttpUtils httpUtils = new HttpUtils();
        try {
            String res = httpUtils.get(url, treeMap);
            log.info("Result:" + res);

            if (StringUtils.isNotEmpty(res)) {
                if (res.contains("<html>")) {
                    log.error("短信服务不可用，返回html...");
                }
                if (res.contains("{")) {
                    JSONObject jsonObject = JSONObject.parseObject(res);
                    String code = jsonObject.getString("code");
                    if (!code.equals("0")) {
                        res = httpUtils.get(url, treeMap);
                        log.info("Failure resend result:" + res);
                    }
                }
            } else {
                log.error("短信服务不可用，返回为空");
            }
        } catch (IllegalStateException ex) {
            if (StringUtils.isNotEmpty(url)) log.error("IllegalStateException", ex);
        } catch (Exception ex) {
            log.error("SendSmsException", ex);
            try {
                String res1 = httpUtils.get(url, treeMap);
                log.info("Exception resend result:" + res1);
            } catch (Exception e) {
                log.error("ReSendSmsException", ex);
            }
        }
    }

//    public static void main(String[] args) {
//        SmsUtils util = new SmsUtils();
//        util.send("18682185876", "您本次操作验证码为：{0}，五分钟内有效。", "frms_sms_assign");
//    }

}
