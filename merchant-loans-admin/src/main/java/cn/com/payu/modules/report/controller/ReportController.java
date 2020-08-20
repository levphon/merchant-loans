package cn.com.payu.modules.report.controller;

import cn.com.payu.modules.model.RankModel;
import cn.com.payu.modules.model.RowsModel;
import cn.com.payu.modules.model.search.ReportSearch;
import cn.com.payu.modules.report.model.RowsModelComparator;
import cn.com.payu.modules.report.service.ReportService;
import com.github.pagehelper.PageInfo;
import com.glsx.plat.core.web.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/report")
public class ReportController {

    @Resource
    private ReportService reportService;

    @GetMapping(value = "/trend")
    public R trend(ReportSearch search) {
        PageInfo<RowsModel> pageInfo = reportService.trend(search);

        Set<String> tempMap = new HashSet<>();
        for (RowsModel model : pageInfo.getList()) {
            tempMap.add(model.getX());
        }

        LocalDate now = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            LocalDate pre = now.minusMonths(i);
            String ym = pre.getYear() + "-" + (pre.getMonthValue() > 9 ? pre.getMonthValue() : "0" + pre.getMonthValue());

            if (!tempMap.contains(ym)) {
                pageInfo.getList().add(new RowsModel(ym, BigInteger.valueOf(0)));
            }
        }
        List<RowsModel> list = pageInfo.getList();
        list.sort(new RowsModelComparator());
        return R.ok().data(list.subList(list.size() - 12, list.size()));
    }

    @GetMapping(value = "/rank")
    public R rank(ReportSearch search) {
        PageInfo<RankModel> pageInfo = reportService.rank(search);
        return R.ok().putPageData(pageInfo);
    }

}
