package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.Salesman;
import cn.com.payu.modules.model.SalesmanModel;
import cn.com.payu.modules.model.export.SalesmanExport;
import cn.com.payu.modules.model.search.SalesmanSearch;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface SalesmanMapper extends CommonBaseMapper<Salesman> {

    List<SalesmanModel> search(SalesmanSearch search);

    List<SalesmanExport> export(SalesmanSearch search);

    SalesmanModel selectById(@Param("id") Long id);

    int logicDeleteById(@Param("id") Long id);

    void enableById(@Param("id") Long id);

    void disableById(@Param("id") Long id);

    Salesman selectByJobNo(@Param("jobNo") String jobNo);

}