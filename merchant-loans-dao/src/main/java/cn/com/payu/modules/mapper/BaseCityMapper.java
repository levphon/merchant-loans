package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.BaseCity;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface BaseCityMapper extends CommonBaseMapper<BaseCity> {

    List<BaseCity> selectByProvCode(@Param("provCode") String provCode);

    BaseCity selectByCode(@Param("cityCode") String cityCode);

}