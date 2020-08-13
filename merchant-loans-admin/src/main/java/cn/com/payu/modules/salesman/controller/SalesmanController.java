package cn.com.payu.modules.salesman.controller;

import cn.com.payu.modules.entity.Salesman;
import cn.com.payu.modules.model.SalesmanModel;
import cn.com.payu.modules.model.export.SalesmanExport;
import cn.com.payu.modules.model.search.SalesmanSearch;
import cn.com.payu.modules.salesman.dto.SalesmanDTO;
import cn.com.payu.modules.salesman.service.SalesmanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glsx.plat.common.utils.DateUtils;
import com.glsx.plat.context.utils.validator.AssertUtils;
import com.glsx.plat.core.web.R;
import com.glsx.plat.office.excel.EasyExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author payu
 */
@RestController
@RequestMapping(value = "/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService salesmanService;

    @GetMapping("/list")
    public R list(SalesmanSearch search) {
        PageHelper.startPage(search.getPageNumber(), search.getPageSize());
        PageInfo<SalesmanModel> pageInfo = salesmanService.search(search);
        return R.ok().putPageData(pageInfo);
    }

    @GetMapping(value = "/export")
    public void export(HttpServletResponse response, SalesmanSearch search) throws Exception {
        List<SalesmanExport> list = salesmanService.export(search);
        EasyExcelUtils.writeExcel(response, list, "业务员_" + DateUtils.formatSerial(new Date()), "Sheet1", SalesmanExport.class);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody SalesmanDTO salesmanDTO) {
        Salesman salesman = salesmanDTO.convertTo();
        salesmanService.save(salesman);
        return R.ok();
    }

    /**
     * 修改
     */
    @PostMapping("/edit")
    public R update(@RequestBody @Valid SalesmanDTO salesmanDTO) {
        AssertUtils.isNull(salesmanDTO.getId(), "ID不能为空");
        Salesman salesman = salesmanDTO.convertTo();
        salesmanService.edit(salesman);
        return R.ok();
    }

    /**
     * 启用停用
     */
    @PostMapping("/enableOrDisable")
    public R enableOrDisable(@RequestBody Integer id) {
        salesmanService.enableOrDisable(id);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        salesmanService.logicDeleteById(ids);
        return R.ok();
    }

}
