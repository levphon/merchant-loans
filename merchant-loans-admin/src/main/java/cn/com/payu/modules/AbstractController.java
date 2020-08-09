//package cn.com.payu.modules;
//
//import org.springframework.stereotype.Controller;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
///**
// * @author liuyf
// * @Title BaseController.java
// * @Package com.hflw.vasp.controller
// * @Description
// * @date 2019年10月24日 下午2:24:00
// */
//@Controller
//public class AbstractController extends BaseController {
//
//    @Resource
//    protected HttpServletRequest request;
//
//    @Resource
//    protected HttpSession session;
//
//    @Resource
//    private UserService userService;
//
//    /**
//     * 从session中获取当前用户
//     *
//     * @return
//     */
//    @Override
//    public Customer getSessionUser() {
//        Customer user = userService.getByToken(request);
//        if (user == null)
//            throw BusinessException.create(ResultCodeEnum.NOT_LOGIN.getCode(), ResultCodeEnum.NOT_LOGIN.getMsg());
//        return user;
//    }
//
//    @Override
//    public String getAccount() {
//        Customer user = getSessionUser();
//        if (user != null) {
//            return user.getPhone();
//        }
//        return null;
//    }
//
//    @Override
//    public Long getUserId() {
//        Customer user = getSessionUser();
//        if (user != null) {
//            return user.getId();
//        }
//        return null;
//    }
//
//}
