package cn.com.payu.modules.salesman.service;

import cn.com.payu.modules.entity.Salesman;
import cn.com.payu.modules.mapper.SalesmanMapper;
import cn.com.payu.modules.model.SalesmanModel;
import cn.com.payu.modules.model.export.SalesmanExport;
import cn.com.payu.modules.model.search.SalesmanSearch;
import com.github.pagehelper.PageInfo;
import com.glsx.plat.core.enums.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanMapper salesmanMapper;

    public PageInfo<SalesmanModel> search(SalesmanSearch search) {
        List<SalesmanModel> list = salesmanMapper.search(search);
        final PageInfo<SalesmanModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public List<SalesmanExport> export(SalesmanSearch search) {
        List<SalesmanExport> list = salesmanMapper.export(search);
        return list;
    }

    public void save(Salesman salesman) {
        salesmanMapper.insert(salesman);
    }

    public void edit(Salesman salesman) {
        salesmanMapper.updateByPrimaryKeySelective(salesman);
    }

    public void enableOrDisable(Integer id) {
        Salesman salesman = salesmanMapper.selectByPrimaryKey(id);
        if (SysConstants.EnableStatus.enable.getCode().equals(salesman.getEnableStatus())) {
            salesmanMapper.disableById(id);
        } else if (SysConstants.EnableStatus.disable.getCode().equals(salesman.getEnableStatus())) {
            salesmanMapper.enableById(id);
        }
    }

    public void logicDeleteById(Integer[] ids) {
        for (Integer id : ids) {
            salesmanMapper.logicDeleteById(id);
        }
    }

}
