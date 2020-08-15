package cn.com.payu.modules.basecities.controller;

import cn.com.payu.modules.basecities.service.BaseCitiesService;
import cn.com.payu.modules.entity.BaseCity;
import com.glsx.plat.core.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 市区
 *
 * @author Mark
 * @date 2019-03-28 13:49:24
 */
@RestController
@RequestMapping("basics/city")
@Validated
public class BaseCitiesController {

    @Autowired
    private BaseCitiesService baseCitiesService;

    /**
     * 根据条件查询
     */
    @RequestMapping("/list")
    public R list(@NotBlank(message = "省份编码不能为空") String provCode) {
        List<BaseCity> list = baseCitiesService.list(provCode);
        return R.ok().data(list);
    }

}
