package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanPersonal;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoanPersonalMapper extends CommonBaseMapper<LoanPersonal> {

    LoanPersonal selectByLoanId(@Param("loanId") Long loanId);

}