package cn.com.payu.modules.baseareas.controller;

import cn.com.payu.modules.baseareas.service.BaseAreasService;
import cn.com.payu.modules.entity.BaseArea;
import com.glsx.plat.core.web.R;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author liuyf
 * @date 2019-04-03 11:33:49
 */
@RestController
@RequestMapping("basics/area")
public class BaseAreasController {

    @Autowired
    private BaseAreasService baseAreasService;

    @RequestMapping("/list")
    public R list(@NotBlank(message = "城市编码不能为空") String cityCode) {
        List<BaseArea> list = baseAreasService.searchByCityCode(cityCode);
        return R.ok().data(list);
    }

}
