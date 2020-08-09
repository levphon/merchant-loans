package cn.com.payu.modules;

import cn.com.payu.modules.customer.service.CustomerService;
import cn.com.payu.modules.entity.Customer;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.exception.SystemMessage;
import com.glsx.plat.wechat.modules.controller.WxMpUserController;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyf
 * @Title UserController.java
 * @Package com.hflw.vasp.controller
 * @Description 微信登录
 * @date 2019年10月24日 下午2:02:54
 */
@Slf4j
@RestController
public class WxLoginController extends WxMpUserController {

    @Resource
    private CustomerService customerService;

    public WxLoginController(WxMpService wxService) {
        super(wxService);
    }

    @Override
    protected Map<String, Object> linkUser(WxMpUser user) {

        Customer customer = customerService.getByWxOpenid(user.getOpenId());
        if (customer != null) {
            customer.setAvatar(user.getHeadImgUrl());
            //更新customer
        }

        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("avatar", user.getHeadImgUrl());
        rtnMap.put("nickname", user.getNickname());
        return rtnMap;
    }

    @Override
    protected Map<String, Object> loginByOpenid(WxMpOAuth2AccessToken accessToken) {
        Customer customer = customerService.getByWxOpenid(accessToken.getOpenId());
        if (customer == null)
            throw BusinessException.create(SystemMessage.NO_LOGIN_INVALID);

        String token = customerService.createToken(customer);

        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("token", token);
        return rtnMap;
    }

}
