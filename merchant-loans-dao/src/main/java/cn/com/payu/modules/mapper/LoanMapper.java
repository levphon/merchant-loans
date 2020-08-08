package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.Loan;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoanMapper extends CommonBaseMapper<Loan> {

    Loan selectByOrderNumber(@Param("orderNumber") String orderNumber);

}