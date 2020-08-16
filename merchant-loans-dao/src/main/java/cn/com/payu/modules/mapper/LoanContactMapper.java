package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanContact;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoanContactMapper extends CommonBaseMapper<LoanContact> {

    List<LoanContact> selectByLoanId(Long loanId);

}