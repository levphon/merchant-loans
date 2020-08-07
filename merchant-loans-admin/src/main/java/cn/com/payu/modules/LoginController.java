package cn.com.payu.modules;

import cn.com.payu.common.enmus.ResultCodeEnum;
import cn.com.payu.modules.entity.User;
import cn.com.payu.modules.user.service.UserService;
import com.glsx.plat.common.annotation.NoLogin;
import com.glsx.plat.common.annotation.SysLog;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.context.utils.PropertiesUtils;
import com.glsx.plat.core.web.R;
import com.glsx.plat.exception.BusinessException;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource
    private UserService userService;

    @Autowired
    private Producer producer;

    @NoLogin
    @GetMapping("captcha")
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
    @SysLog
    @PostMapping(value = "/login")
    public R login(@RequestParam String username, @RequestParam String password, String captcha) {

        User user = userService.findByUsername(username);

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
    @SysLog
    @PostMapping(value = "/customer/login")
    public R login(@RequestParam String phone, @RequestParam String code) {

        User user = userService.findByPhone(phone);
        user.setPhone(phone);

        // TODO: 2020/8/7 验证码校验

        String token = userService.createToken(user);

        Map<String, Object> rtnMap = new HashMap<>();
        rtnMap.put("token", token);
        rtnMap.put("user", user);
        return R.ok().data(rtnMap);
    }

}
