package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "d_loan_social")
public class LoanSocial extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 现投保单位
     */
    @Column(name = "insured_address")
    private String insuredAddress;

    /**
     * 现投保时长(单位：月)
     */
    @Column(name = "insured_day")
    private Integer insuredDay;

    /**
     * 原投保单位
     */
    @Column(name = "old_address")
    private String oldAddress;

    /**
     * 投保工资标准(单位：元），浮点数，保留2位
     */
    @Column(name = "insured_standard")
    private Float insuredStandard;

    /**
     * 查询时间，时间戳
     */
    @Column(name = "get_social_time")
    private Date getSocialTime;

    /**
     * 养老金余额(单位：元），浮点数，保留2位
     */
    private Float annuity;

    /**
     * 医疗保险余额(单位：元），浮点数，保留2位
     */
    private Float medical;

    /**
     * 最早投保时间,时间戳
     */
    @Column(name = "earliest_date")
    private Date earliestDate;

    /**
     * 近三个月投保状态 1正常0不正常
     */
    @Column(name = "lately_status")
    private Integer latelyStatus;

}