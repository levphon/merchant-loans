package cn.com.payu.modules.baseprovinces.controller;

import cn.com.payu.modules.baseprovinces.service.BaseProvincesService;
import cn.com.payu.modules.entity.BaseProvince;
import com.glsx.plat.core.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 省份
 *
 * @author Mark
 * @date 2019-03-28 10:17:01
 */
@RestController
@RequestMapping("basics/province")
public class BaseProvincesController {

    @Autowired
    private BaseProvincesService baseProvinceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list() {
        List<BaseProvince> list = baseProvinceService.list();
        return R.ok().data(list);
    }

}
