package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.MessageTemplate;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface MessageTemplateMapper extends CommonBaseMapper<MessageTemplate> {

    MessageTemplate findByKey(@Param("template") String template);

}