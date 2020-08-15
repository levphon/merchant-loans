package cn.com.payu.modules.common.service;

import cn.com.payu.common.constant.Constants;
import cn.com.payu.common.constant.MessageTemplateKeys;
import cn.com.payu.common.enmus.ResultCodeEnum;
import com.glsx.plat.common.utils.SnowFlake;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.context.utils.PropertiesUtils;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.redis.utils.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuyf
 * @Title CommonServiceImpl.java
 * @Package com.glsx.vasp.service.impl
 * @Description 公共Service
 * @date 2019年10月22日 下午3:01:25
 */
@Service
public class CommonService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private MessageService messageService;

    /**
     * 发送验证码
     *
     * @param phone
     */
    public void sendCode(String phone) {

        String smsKey = Constants.SMS_VERIFY_CODE_PREFIX + phone;

//        String repeat = "repeat";
//
//        if (redisCacheUtil.exists(smsKey + repeat)) throw BusinessException.create("请等待60秒后再发送验证码");
//
//        redisCacheUtil.set(smsKey + repeat, repeat, BasicConstants.SMS_VERIFY_CODE_REPEAT_TIMEOUT, TimeUnit.SECONDS);

        String code = StringUtils.generateRandomCode(true, 4);

        String smsSwitch = PropertiesUtils.getProperty("sms.switch");
        if ("on".equalsIgnoreCase(smsSwitch)) {
            messageService.sendSms(phone, MessageTemplateKeys.SMS_TEMPLATE_VERIFICATION_CODE);
        } else {
            code = "1234";
        }
        redisUtils.set(smsKey, code, Constants.SMS_VERIFY_CODE_TIMEOUT);
    }

    /**
     * 验证验证码
     *
     * @param phone
     * @param code
     */
    public void verifyCode(String phone, String code) {
        String realVerifyCode = (String) redisUtils.get(Constants.SMS_VERIFY_CODE_PREFIX + phone);
        if (StringUtils.isBlank(realVerifyCode))
            throw BusinessException.create(ResultCodeEnum.SMS_VERIFY_CODE_TIMEOUT.getMsg());
        if (!realVerifyCode.equals(code))
            throw BusinessException.create(ResultCodeEnum.SMS_VERIFY_CODE_NOT_RIGHT.getMsg());
    }

    public long snowFlakeId() {
        // 锁表 一小时的超时时间
//        if (!redisService.addRedisLock(ConstantKeys.REDIS_LOCK_MAX_ORDER_NUMBER, 2000, 2)) {
//            return 0;
//        }
        long id = SnowFlake.nextId();
//        // 解锁
//        redisService.delRedisLock(ConstantKeys.REDIS_LOCK_MAX_ORDER_NUMBER);
        return id;
    }

}
