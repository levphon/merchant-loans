package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexLoan {

    /**
     * 贷款产品id，我方提供
     */
    private Integer productId;

    /**
     * 客户贷款金额(单位：元)
     */
    private Integer annuity;

    /**
     * 客户贷款用途，详见字典说明
     */
    private Integer loanPurpose;

    /**
     * 客户申请期限，详见字典说明
     */
    private Integer loanPeriod;

    /**
     * 建议费率，保留两位小数，默认为：0
     */
    private Float merchantRate;

    /**
     * 还款方式，详见字典说明，默认为：2
     */
    private Integer payMethod;

}
