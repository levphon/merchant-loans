package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.Salesman;
import cn.com.payu.modules.model.SalesmanModel;
import cn.com.payu.modules.model.export.SalesmanExport;
import cn.com.payu.modules.model.search.SalesmanSearch;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesmanMapper extends CommonBaseMapper<Salesman> {

    List<SalesmanModel> search(SalesmanSearch search);

    List<SalesmanExport> export(SalesmanSearch search);

    int logicDeleteById(Integer id);

    void enableById(Integer id);

    void disableById(Integer id);

}