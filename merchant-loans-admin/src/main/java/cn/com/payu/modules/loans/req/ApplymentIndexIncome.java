package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.util.List;

@Data
public class ApplymentIndexIncome {

    /**
     * 对私银行流水信息
     */
    private List<ApplymentIndexIncomePrivate> privateIncome;

    /**
     * 对公银行流水信息
     */
    private List<ApplymentIndexIncomePublic> publicIncome;

}
