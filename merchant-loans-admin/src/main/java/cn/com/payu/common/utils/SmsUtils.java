package cn.com.payu.common.utils;

import com.glsx.plat.common.utils.HttpUtils;
import com.glsx.plat.common.utils.SnowFlake;
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
        treeMap.put("SpCode", properties.getSource());
        treeMap.put("LoginName", properties.getAccessKeyId());
        treeMap.put("Password", properties.accessKeySecret);
        treeMap.put("UserNumber", phone);
        treeMap.put("MessageContent", String.format("%s%s", properties.signName, content));
        treeMap.put("SerialNumber", SnowFlake.nextSerialNumber());
        treeMap.put("ScheduleTime", "");

        log.info("Send Sms:" + treeMap.toString());
        String url = properties.getUrl();

        log.info("短信接口：" + url);

        HttpUtils httpUtils = new HttpUtils();
        try {
            String res = httpUtils.post(url, treeMap);
            log.info("Result:" + res);
            if (StringUtils.isNotEmpty(res)) {
                if (res.contains("<html>")) {
                    log.error("短信服务不可用，返回html...");
                }
                if (res.contains("result=0")) {
                    log.info("发送成功：" + res);
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
