package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexIncomePrivate {

    /**
     * 近1个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlyOneMonth;

    /**
     * 近2个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlyTwoMonth;

    /**
     * 近3个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlyThirdMonth;

    /**
     * 近4个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlyFourMonth;

    /**
     * 近5个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlyFiveMonth;

    /**
     * 近6个月流水(单位：元)，浮点数，保留2位
     */
    private BigDecimal nearlySixMonth;

    /**
     * 结息金额(单位：元)，浮点数，保留2位
     */
    private BigDecimal interestAmount;

}
