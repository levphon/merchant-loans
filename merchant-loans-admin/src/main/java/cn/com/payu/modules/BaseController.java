package cn.com.payu.modules;

import cn.com.payu.modules.customer.service.CustomerService;
import cn.com.payu.modules.entity.Customer;
import com.glsx.plat.exception.BusinessException;
import com.glsx.plat.exception.SystemMessage;
import com.glsx.plat.web.controller.AbstractController;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author payu
 */
@Controller
public class BaseController extends AbstractController {

    @Resource
    private CustomerService customerService;

    /**
     * 从session中获取当前用户
     *
     * @return
     */
    @Override
    public Customer getSessionUser() {
        Customer user = customerService.getByToken();
        if (user == null)
            throw BusinessException.create(SystemMessage.NOT_LOGIN);
        return user;
    }

    @Override
    public String getAccount() {
        Customer user = getSessionUser();
        if (user != null) {
            return user.getPhone();
        }
        return null;
    }

    @Override
    public Long getUserId() {
        Customer user = getSessionUser();
        if (user != null) {
            return user.getId();
        }
        return null;
    }

}
