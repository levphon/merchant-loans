package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexIncomePrivate {

    /**
     * 近1个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlyOneMonth;

    /**
     * 近2个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlyTwoMonth;

    /**
     * 近3个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlyThirdMonth;

    /**
     * 近4个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlyFourMonth;

    /**
     * 近5个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlyFiveMonth;

    /**
     * 近6个月流水(单位：元)，浮点数，保留2位
     */
    private Float nearlySixMonth;

    /**
     * 结息金额(单位：元)，浮点数，保留2位
     */
    private Float interestAmount;

}
