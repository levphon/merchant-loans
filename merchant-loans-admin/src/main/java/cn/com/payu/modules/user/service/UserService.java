package cn.com.payu.modules.user.service;

import cn.com.payu.common.exception.AdminException;
import cn.com.payu.modules.entity.User;
import cn.com.payu.modules.mapper.UserMapper;
import cn.com.payu.modules.user.utils.JwtUser;
import com.glsx.plat.common.utils.StringUtils;
import com.glsx.plat.core.constant.BasicConstants;
import com.glsx.plat.exception.SystemMessage;
import com.glsx.plat.jwt.util.JwtUtils;
import com.glsx.plat.jwt.util.ObjectUtils;
import com.glsx.plat.web.utils.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Resource
    private JwtUtils jwtUtils;

    @Resource
    private UserMapper userMapper;

    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    public User findByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    public String createToken(User user) {
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
    public User getByToken() {

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
        User user = new User();
        user.setId(StringUtils.isNotEmpty(jwtUser.getUserId()) ? Long.parseLong(jwtUser.getUserId()) : null);
        user.setPhone(jwtUser.getPhone());
        return user;
    }


}
