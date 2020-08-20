package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.Customer;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface CustomerMapper extends CommonBaseMapper<Customer> {

    Customer selectByPhone(@Param("phone") String phone);

    Customer selectByWxOpenid(@Param("openId") String openId);

}