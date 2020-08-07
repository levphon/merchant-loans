package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexIncome {

    /**
     * 对私银行流水信息
     */
    private ApplymentIndexIncomePrivate privateIncome;

    /**
     * 对公银行流水信息
     */
    private ApplymentIndexIncomePublic publicIncome;

}
