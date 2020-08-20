package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanEsign;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface LoanEsignMapper extends CommonBaseMapper<LoanEsign> {

    List<LoanEsign> selectByLoanId(@Param("loanId") Long loanId);

}