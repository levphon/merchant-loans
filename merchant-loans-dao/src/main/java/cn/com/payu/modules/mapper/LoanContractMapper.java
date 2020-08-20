package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanContract;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface LoanContractMapper extends CommonBaseMapper<LoanContract> {

    List<LoanContract> selectByLoanId(@Param("loanId") Long loanId);

}