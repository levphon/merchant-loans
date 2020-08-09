package cn.com.payu.modules.customer.service;

import cn.com.payu.common.exception.AdminException;
import cn.com.payu.modules.entity.Customer;
import cn.com.payu.modules.entity.User;
import cn.com.payu.modules.mapper.CustomerMapper;
import cn.com.payu.modules.user.utils.JwtUser;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.core.constant.BasicConstants;
import com.glsx.plat.exception.SystemMessage;
import com.glsx.plat.jwt.util.JwtUtils;
import com.glsx.plat.jwt.util.ObjectUtils;
import com.glsx.plat.web.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private CustomerMapper customerMapper;

    public Customer findByPhone(String phone) {
        return customerMapper.selectByPhone(phone);
    }

    public Customer getByWxOpenid(String openId) {
        return customerMapper.selectByWxOpenid(openId);
    }

    public String createToken(Customer user) {
        String jwtId = UUID.randomUUID().toString(); //JWT 随机ID,做为验证的key

        JwtUser jwtUser = new JwtUser();
        jwtUser.setJwtId(jwtId);
        jwtUser.setUserId(String.valueOf(user.getId()));
        jwtUser.setPhone(user.getPhone());
        jwtUser.setApplication(jwtUtils.getApplication());

        Map<String, String> userMap = (Map<String, String>) ObjectUtils.objectToMap(jwtUser);

        return jwtUtils.createToken(jwtId, userMap);
    }

    /**
     * 根据Token获取Customer
     */
    public Customer getByToken() {

        String token = SessionUtils.request().getHeader(BasicConstants.REQUEST_HEADERS_TOKEN);

        if (StringUtils.isNullOrEmpty(token)) throw new AdminException(SystemMessage.ILLEGAL_ACCESS.getCode(), "登录已失效");

        if (token.startsWith("Bearer")) token = token.replace("Bearer ", "");

        //解析token，反转成JwtUser对象
        Map<String, Object> userMap = jwtUtils.parseClaim(JwtUser.class, token);
        JwtUser jwtUser = null;
        try {
            jwtUser = (JwtUser) ObjectUtils.mapToObject(userMap, JwtUser.class);
        } catch (Exception e) {
            throw new AdminException(SystemMessage.ILLEGAL_ACCESS.getCode(), "登录已失效");
        }
        Customer user = new Customer();
        user.setId(StringUtils.isNotEmpty(jwtUser.getUserId()) ? Long.parseLong(jwtUser.getUserId()) : null);
        user.setPhone(jwtUser.getPhone());
        return user;
    }

}
