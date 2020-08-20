package cn.com.payu.modules.report.service;


import cn.com.payu.modules.mapper.ReportMapper;
import cn.com.payu.modules.model.RankModel;
import cn.com.payu.modules.model.RowsModel;
import cn.com.payu.modules.model.search.ReportSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportService {

    @Autowired
    private ReportMapper reportMapper;

    public PageInfo<RowsModel> trend(ReportSearch search) {
        List<RowsModel> list = reportMapper.selectTrendData(search);
        return new PageInfo<>(list);
    }

    public PageInfo<RankModel> rank(ReportSearch search) {
        List<RankModel> list = reportMapper.selectRankData(search);
        return new PageInfo<>(list);
    }

}
