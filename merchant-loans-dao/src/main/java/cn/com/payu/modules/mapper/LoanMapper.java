package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.Loan;
import cn.com.payu.modules.model.OrderModel;
import cn.com.payu.modules.model.export.OrderExport;
import cn.com.payu.modules.model.search.OrderSearch;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper extends CommonBaseMapper<Loan> {

    Loan selectByOrderNumber(@Param("orderNumber") String orderNumber);

    Loan selectByApplyNumber(@Param("applyNumber") String applyNumber);

    List<OrderModel> search(OrderSearch search);

    List<OrderExport> export(OrderSearch search);

}