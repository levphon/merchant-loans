package cn.com.payu.modules;

import cn.com.payu.common.enmus.ResultCodeEnum;
import cn.com.payu.modules.common.service.CommonService;
import cn.com.payu.modules.customer.model.LoginByMobileDTO;
import cn.com.payu.modules.customer.service.CustomerService;
import cn.com.payu.modules.entity.Customer;
import cn.com.payu.modules.entity.User;
import cn.com.payu.modules.user.model.LoginDTO;
import cn.com.payu.modules.user.service.UserService;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.context.utils.PropertiesUtils;
import com.glsx.plat.core.web.R;
import com.glsx.plat.exception.BusinessException;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author payu
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private Producer producer;

    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = PropertiesUtils.getProperty("captcha.sessionRad");
        if (StringUtils.isNullOrEmpty(text)) text = producer.createText();

        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到 session
        request.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 后端管理登录
     */
    @PostMapping(value = "/login")
    public R adminLogin(@RequestBody LoginDTO loginDTO) {

        User user = userService.findByUsername(loginDTO.getUsername());

        if (user == null)
            throw BusinessException.create(ResultCodeEnum.UNKNOWN_ACCOUNT.getCode(), ResultCodeEnum.UNKNOWN_ACCOUNT.getMsg());

        // TODO: 2020/8/7 密码校验


        String token = userService.createToken(user);

        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("token", token);
        rtnMap.put("user", user);
        return R.ok().data(rtnMap);
    }

    /**
     * 验证码校验
     *
     * @param request
     * @param captcha
     */
    protected void doCaptchaValidate(HttpServletRequest request, String captcha) {
        // 从session中获取图形吗字符串
        String kaptcha = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //删除缓存验证码
        request.getSession().removeAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        // 校验
        if (kaptcha == null || !kaptcha.equals(captcha)) {
            throw BusinessException.create(ResultCodeEnum.INCORRECT_CAPTCHA.getCode(), ResultCodeEnum.INCORRECT_CAPTCHA.getMsg());
        }
    }

    /**
     * h5登录
     */
    @PostMapping(value = "/customer/login")
    public R customerLogin(@RequestBody LoginByMobileDTO loginDTO) {

        commonService.verifyCode(loginDTO.getPhone(), loginDTO.getCode());

        Customer customer = customerService.login(loginDTO);

        if (customer == null)
            throw BusinessException.create(ResultCodeEnum.UNKNOWN_ACCOUNT.getCode(), ResultCodeEnum.UNKNOWN_ACCOUNT.getMsg());

        String token = customerService.createToken(customer);

        return R.ok().data(token);
    }

}
