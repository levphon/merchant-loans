package cn.com.payu.modules.mapper;

import cn.com.payu.modules.model.RankModel;
import cn.com.payu.modules.model.RowsModel;
import cn.com.payu.modules.model.search.ReportSearch;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface ReportMapper extends CommonBaseMapper<RowsModel> {

    List<RowsModel> selectTrendData(ReportSearch search);

    List<RankModel> selectRankData(ReportSearch search);

}