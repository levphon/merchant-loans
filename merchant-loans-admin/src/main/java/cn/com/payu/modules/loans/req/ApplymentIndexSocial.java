package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexSocial {

    /**
     * 现投保单位
     */
    private String insuredAddress;

    /**
     * 现投保时长(单位：月)
     */
    private Integer insuredDay;

    /**
     * 原投保单位
     */
    private String oldAddress;

    /**
     * 投保工资标准(单位：元），浮点数，保留2位
     */
    private BigDecimal insuredStandard;

    /**
     * 查询时间，时间戳
     */
    private String getSocialTime;

    /**
     * 养老金余额(单位：元），浮点数，保留2位
     */
    private BigDecimal annuity;

    /**
     * 医疗保险余额(单位：元），浮点数，保留2位
     */
    private BigDecimal medical;

    /**
     * 最早投保时间,时间戳
     */
    private String earliestDate;

    /**
     * 近三个月投保状态 1正常0不正常
     */
    private String latelyStatus;

}
