package cn.com.payu.modules.loans.req;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ApplymentIndexJob {

    /**
     * 客户类型 1：工薪类,2：生意类
     */
    private Integer businessType;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 经营时间(生意类),时间戳
     */
    private Long operateTime;

    /**
     * 行业类别的编码
     */
    private Integer industryCode;

    /**
     * 公司电话
     */
    private String contactNumber;

    /**
     * 公司营业额,单位：元(生意类)，浮点数，保留2位
     */
    private BigDecimal monthTurnover;

    /**
     * 公司地址
     */
    private String operateAddress;

    /**
     * 入职时间(工薪类),时间戳
     */
    private Long hiredTime;

    /**
     * 入职职位(工薪类)
     */
    private String station;

    /**
     * 薪水,单位：元(工薪类)，浮点数，保留2位
     */
    private BigDecimal wage;

    /**
     * 单位性质(工薪类)，详见字典说明
     */
    private Integer unitType;

}
