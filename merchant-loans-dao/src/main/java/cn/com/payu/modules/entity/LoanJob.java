package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "d_loan_job")
public class LoanJob extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 客户类型 1：工薪类,2：生意类
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 经营时间(生意类),时间戳
     */
    @Column(name = "operate_time")
    private Date operateTime;

    /**
     * 行业类别的编码
     */
    @Column(name = "industry_code")
    private String industryCode;

    /**
     * 公司电话
     */
    @Column(name = "contact_number")
    private String contactNumber;

    /**
     * 公司营业额,单位：元(生意类)，浮点数，保留2位
     */
    @Column(name = "month_turnover")
    private Float monthTurnover;

    /**
     * 公司地址
     */
    @Column(name = "operate_address")
    private String operateAddress;

    /**
     * 入职时间(工薪类),时间戳
     */
    @Column(name = "hired_time")
    private Date hiredTime;

    /**
     * 入职职位(工薪类)
     */
    private String station;

    /**
     * 薪水,单位：元(工薪类)，浮点数，保留2位
     */
    private Float wage;

    /**
     * 单位性质(工薪类)，详见字典说明
     */
    @Column(name = "unitType")
    private Integer unittype;

}