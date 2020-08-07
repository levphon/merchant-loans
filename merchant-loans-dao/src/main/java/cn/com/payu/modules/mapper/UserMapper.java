package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.User;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends CommonBaseMapper<User> {

    User selectByUsername(@Param("username") String username);

    User selectByPhone(@Param("phone") String phone);

    void logicDeleteById(Long id);

}