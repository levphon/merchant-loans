package cn.com.payu.modules.common.controller;

import cn.com.payu.modules.common.service.CommonService;
import com.glsx.plat.common.annotation.NoLogin;
import com.glsx.plat.core.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * 通用请求处理
 *
 * @author liuyf
 */
@Slf4j
@RestController
@RequestMapping(value = "/common")
public class CommonController {

    @Resource
    private CommonService commonService;

    @NoLogin
    @RequestMapping(value = "/sendCode", method = {RequestMethod.GET, RequestMethod.POST})
    public R sendCode(@NotBlank(message = "手机号码不能为空") String phone) {
        commonService.sendCode(phone);
        return R.ok();
    }

}
