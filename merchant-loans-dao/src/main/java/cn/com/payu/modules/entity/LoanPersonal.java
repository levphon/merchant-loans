package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "d_loan_personal")
public class LoanPersonal extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 客户名称(必须中文，2-20个汉字)
     */
    private String name;

    /**
     * 性别，详见字典说明
     */
    private Integer gender;

    /**
     * 证件类型，默认为1，详见字典说明
     */
    @Column(name = "certificate_type")
    private Integer certificateType;

    /**
     * 证件号(比如身份证号)
     */
    @Column(name = "certificate_number")
    private String certificateNumber;

    /**
     * 证件到期日期，时间戳
     */
    @Column(name = "certificate_expiryDate")
    private Date certificateExpirydate;

    /**
     * 证件发证机关
     */
    private String institution;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最高学历，详见字典说明
     */
    @Column(name = "education_info")
    private Integer educationInfo;

    /**
     * 婚姻状态，详见字典说明
     */
    @Column(name = "marriage_info")
    private Integer marriageInfo;

}