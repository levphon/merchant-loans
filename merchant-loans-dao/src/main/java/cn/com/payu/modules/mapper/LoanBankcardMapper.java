package cn.com.payu.modules.mapper;

import cn.com.payu.modules.entity.LoanBankcard;
import com.glsx.plat.mybatis.mapper.CommonBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoanBankcardMapper extends CommonBaseMapper<LoanBankcard> {

    LoanBankcard selectByLoanId(@Param("loanId") Long loanId);

    LoanBankcard selectBy4Element(@Param("accountName") String accountName,
                                  @Param("idcardNo") String idcardNo,
                                  @Param("accountNo") String accountNo,
                                  @Param("mobile") String mobile);

}