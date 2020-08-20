package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanPlans;
import cn.com.payu.modules.model.LoanPlansModel;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface LoanPlansMapper extends CommonBaseMapper<LoanPlans> {

    LoanPlans selectByLoanIdAndPeriods(@Param("loanId") Long loanId, @Param("periods") Integer periods);

    List<LoanPlans> selectByLoanId(@Param("loanId") Long loanId);

    List<LoanPlansModel> selectDetailsByLoanId(@Param("loanId") Long loanId);

}