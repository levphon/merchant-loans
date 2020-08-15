package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.BaseArea;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BaseAreaMapper extends CommonBaseMapper<BaseArea> {

    List<BaseArea> selectByCityCode(@Param("cityCode") String cityCode);

}