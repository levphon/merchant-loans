package cn.com.payu.modules.common.service;

import cn.com.payu.common.constant.Constants;
import cn.com.payu.common.constant.MessageTemplateKeys;
import cn.com.payu.common.enmus.ResultCodeEnum;
import cn.com.payu.modules.entity.BaseArea;
import cn.com.payu.modules.entity.BaseCity;
import cn.com.payu.modules.entity.BaseProvince;
import cn.com.payu.modules.mapper.BaseAreaMapper;
import cn.com.payu.modules.mapper.BaseCityMapper;
import cn.com.payu.modules.mapper.BaseProvinceMapper;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.context.utils.PropertiesUtils;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author liuyf
 * @Description 公共Service
 * @date 2019年10月22日 下午3:01:25
 */
@Slf4j
@Service
public class CommonService {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private MessageService messageService;

    @Autowired
    private BaseProvinceMapper provinceMapper;

    @Autowired
    private BaseCityMapper cityMapper;

    @Autowired
    private BaseAreaMapper areaMapper;

    /**
     * 发送验证码
     *
     * @param phone
     */
    public void sendCode(String phone) {

        String phoneKey = Constants.MLOANS + phone;
        int dailyCnt = getRedisDailyCnt(phoneKey);
        int dailyLimit = Integer.parseInt(PropertiesUtils.getProperty("sms.limit", "0"));
        log.info("{} 今日第{}次发送，每日限额：{}", phoneKey, dailyCnt + 1, dailyLimit);
        if (dailyCnt >= dailyLimit)
            throw BusinessException.create(ResultCodeEnum.SMS_VERIFY_CODE_SEND_LIMIT.getCode(), ResultCodeEnum.SMS_VERIFY_CODE_SEND_LIMIT.getMsg());

        String smsKey = Constants.SMS_VERIFY_CODE_PREFIX + phone;
//        String repeat = "repeat";
//
//        if (redisCacheUtil.exists(smsKey + repeat)) throw BusinessException.create("请等待60秒后再发送验证码");
//
//        redisCacheUtil.set(smsKey + repeat, repeat, BasicConstants.SMS_VERIFY_CODE_REPEAT_TIMEOUT, TimeUnit.SECONDS);

        String code = StringUtils.generateRandomCode(true, 4);

        String smsSwitch = PropertiesUtils.getProperty("sms.switch");
        if ("on".equalsIgnoreCase(smsSwitch)) {
            messageService.sendSms(phone, MessageTemplateKeys.SMS_TEMPLATE_VERIFICATION_CODE, code);
        } else {
            code = "1234";
        }
        redisUtils.set(smsKey, code, Constants.SMS_VERIFY_CODE_TIMEOUT);
        setRedisDailyCnt(phoneKey);
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

    public String getProvinceName(String provCode) {
        BaseProvince province = provinceMapper.selectByCode(provCode);
        return province != null ? province.getName() : "";
    }

    public String getCityName(String cityCode) {
        BaseCity city = cityMapper.selectByCode(cityCode);
        return city != null ? city.getName() : "";
    }

    public String getAreaName(String areaCode) {
        BaseArea area = areaMapper.selectByCode(areaCode);
        return area != null ? area.getName() : "";
    }

    public String getProvCityAreaName(String provCode, String cityCode, String areaCode) {
        return getProvinceName(provCode) + getCityName(cityCode) + getAreaName(areaCode);
    }

    /**
     * 设置每天缓存次数
     *
     * @param key
     * @return
     */
    public int setRedisDailyCnt(String key) {
        Integer cnt = (Integer) redisUtils.get(key);
        if (cnt == null) cnt = 0;
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        //long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
        redisUtils.set(key, ++cnt, seconds);
        return cnt;
    }

    /**
     * 获取每天缓存次数
     *
     * @param key
     * @return
     */
    public int getRedisDailyCnt(String key) {
        Integer cnt = (Integer) redisUtils.get(key);
        if (cnt == null) cnt = 0;
        return cnt;
    }

}
