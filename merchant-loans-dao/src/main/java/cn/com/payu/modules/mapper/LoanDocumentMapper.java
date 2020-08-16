package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanDocument;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanDocumentMapper extends CommonBaseMapper<LoanDocument> {

    List<LoanDocument> selectAllByLoanId(@Param("loanId") Long loanId);

    List<LoanDocument> selectByLoanIdAndType(@Param("loanId") Long loanId,@Param("type")Integer type);

}