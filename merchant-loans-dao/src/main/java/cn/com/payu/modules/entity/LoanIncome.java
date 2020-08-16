package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_income")
public class LoanIncome extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 流水类型 1：对私银行流水信息,2：对公银行流水信息
     */
    @Column(name = "income_type")
    private Integer incomeType;

    /**
     * 近1个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_one_month")
    private Float nearlyOneMonth;

    /**
     * 近2个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_two_month")
    private Float nearlyTwoMonth;

    /**
     * 近3个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_third_month")
    private Float nearlyThirdMonth;

    /**
     * 近4个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_four_month")
    private Float nearlyFourMonth;

    /**
     * 近5个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_five_month")
    private Float nearlyFiveMonth;

    /**
     * 近6个月流水(单位：元)，浮点数，保留2位
     */
    @Column(name = "nearly_six_month")
    private Float nearlySixMonth;

    /**
     * 结息金额(单位：元)，浮点数，保留2位
     */
    @Column(name = "interest_amount")
    private Float interestAmount;

}