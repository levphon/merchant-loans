package cn.com.payu.modules.order.controller;

import cn.com.payu.modules.model.OrderModel;
import cn.com.payu.modules.model.export.OrderExport;
import cn.com.payu.modules.model.search.OrderSearch;
import cn.com.payu.modules.order.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.glsx.plat.common.utils.DateUtils;
import com.glsx.plat.core.web.R;
import com.glsx.plat.office.excel.EasyExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author payu
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/search")
    public R search(OrderSearch search) {
        PageHelper.startPage(search.getPageNumber(), search.getPageSize());
        PageInfo<OrderModel> pageInfo = orderService.search(search);
        return R.ok().putPageData(pageInfo);
    }

    @GetMapping(value = "/export")
    public void export(HttpServletResponse response, OrderSearch search) throws Exception {
        List<OrderExport> list = orderService.export(search);
        EasyExcelUtils.writeExcel(response, list, "订单_" + DateUtils.formatSerial(new Date()), "Sheet1", OrderExport.class);
    }

}
