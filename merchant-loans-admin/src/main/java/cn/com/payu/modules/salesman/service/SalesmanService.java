package cn.com.payu.modules.salesman.service;

import cn.com.payu.modules.entity.Salesman;
import cn.com.payu.modules.mapper.SalesmanMapper;
import cn.com.payu.modules.model.SalesmanModel;
import cn.com.payu.modules.model.export.SalesmanExport;
import cn.com.payu.modules.model.search.SalesmanSearch;
import com.github.pagehelper.PageInfo;
import com.glsx.plat.core.enums.SysConstants;
import com.glsx.plat.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanMapper salesmanMapper;

    public PageInfo<SalesmanModel> search(SalesmanSearch search) {
        List<SalesmanModel> list = salesmanMapper.search(search);
        for (SalesmanModel sm : list) {
            sm.setEnableStatusDesc(SysConstants.EnableStatus.getValueByCode(sm.getEnableStatus()));
        }
        return new PageInfo<>(list);
    }

    public List<SalesmanExport> export(SalesmanSearch search) {
        List<SalesmanExport> list = salesmanMapper.export(search);
        for (SalesmanExport se : list) {
            se.setEnableStatusDesc(SysConstants.EnableStatus.getValueByCode(se.getEnableStatus()));
        }
        return list;
    }

    public SalesmanModel getById(Long id) {
        return salesmanMapper.selectById(id);
    }

    public void add(Salesman salesman) {
        checkExistSalesman(salesman);
        salesmanMapper.insert(salesman);
    }

    public void edit(Salesman salesman) {
        checkExistSalesman(salesman);
        salesmanMapper.updateByPrimaryKeySelective(salesman);
    }

    public void checkExistSalesman(Salesman salesman) {
        Salesman sm = salesmanMapper.selectByJobNo(salesman.getJobNo());
        if (sm != null) {
            if (salesman.getId() == null)
                throw BusinessException.create("业务员编号已存在");

            if (!salesman.getId().equals(sm.getId()))
                throw BusinessException.create("业务员编号已存在");
        }
    }

    public void enableOrDisable(Long id) {
        Salesman salesman = salesmanMapper.selectByPrimaryKey(id);
        if (SysConstants.EnableStatus.enable.getCode().equals(salesman.getEnableStatus())) {
            salesmanMapper.disableById(id);
        } else if (SysConstants.EnableStatus.disable.getCode().equals(salesman.getEnableStatus())) {
            salesmanMapper.enableById(id);
        }
    }

    public void logicDeleteById(Long[] ids) {
        for (Long id : ids) {
            salesmanMapper.logicDeleteById(id);
        }
    }

}
