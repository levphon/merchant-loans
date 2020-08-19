package cn.com.payu.modules.model;

import cn.com.payu.modules.model.LoanPlansModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class RepayIn7DayDetails {

    /**
     * 借款编号
     */
    private String orderNumber;

    /**
     * 客户贷款金额(单位：元)
     */
    private Integer annuity;

    /**
     * 客户申请期限，详见字典说明
     */
    private Integer loanPeriod;

    /**
     * 借款日期
     */
    private Date loanDate;

    /**
     * 已还期数
     */
    private Integer repaidPeriod;


    /**
     * 剩余本金
     */
    private BigDecimal planRemainPrincipal;

    /**
     * 全部应还
     */
    private BigDecimal planRemainTotal;

    private List<LoanPlansModel> plans;

}
