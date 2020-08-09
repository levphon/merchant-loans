package cn.com.payu.modules.common.service;

import cn.com.payu.common.utils.SmsUtils;
import cn.com.payu.modules.entity.MessageLog;
import cn.com.payu.modules.entity.MessageTemplate;
import cn.com.payu.modules.mapper.MessageLogMapper;
import cn.com.payu.modules.mapper.MessageTemplateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;

@Slf4j
@Service
public class MessageService {

    @Resource
    private SmsUtils smsUtils;

    @Resource
    private MessageLogMapper messageLogMapper;

    @Resource
    private MessageTemplateMapper messageTemplateMapper;

    public void sendSms(String phone, String template, Object... arg) {
        MessageTemplate mt = messageTemplateMapper.findByKey(template);
        if (mt == null) {
            log.warn("短信模板{}不存在", template);
            return;
        }

        String content = MessageFormat.format(mt.getContent(), arg);
        smsUtils.send(phone, content);

        MessageLog log = new MessageLog();
        log.setToUser(phone);
        log.setContent(content);
        log.setTemplate(template);
        log.setType(mt.getType());
        messageLogMapper.insert(log);
    }


}
