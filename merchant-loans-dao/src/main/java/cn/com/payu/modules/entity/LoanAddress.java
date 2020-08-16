package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "d_loan_address")
public class LoanAddress extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 与谁居住，详见字典说明
     */
    @Column(name = "together_dwell")
    private Integer togetherDwell;

    /**
     * 住宅类型，详见字典说明
     */
    @Column(name = "housing_type")
    private Integer housingType;

    /**
     * 起始居住日期,时间戳
     */
    @Column(name = "live_date")
    private Date liveDate;

    /**
     * 每月租金(按揭房时为月供金额，非租房时设置为0），浮点数，保留2位
     */
    @Column(name = "month_rent")
    private Float monthRent;

    /**
     * 现地址的省份
     */
    @Column(name = "present_province")
    private String presentProvince;

    /**
     * 现地址的城市
     */
    @Column(name = "present_city")
    private String presentCity;

    /**
     * 现地址的地区
     */
    @Column(name = "present_region")
    private String presentRegion;

    /**
     * 现地址的详细地址
     */
    @Column(name = "present_address")
    private String presentAddress;

}