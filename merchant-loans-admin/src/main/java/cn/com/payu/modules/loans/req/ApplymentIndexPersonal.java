package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexPersonal {

    /**
     * 客户名称
     */
    private String name;

    /**
     * 性别，详见字典说明
     */
    private Integer gender;

    /**
     * 证件类型，默认为1，详见字典说明
     */
    private Integer certificateType;

    /**
     * 证件号(比如身份证号)
     */
    private String certificateNumber;

    /**
     * 证件到期日期，时间戳
     */
    private String certificateExpiryDate;

    /**
     * 证件发证机关
     */
    private String institution;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最高学历，详见字典说明
     */
    private Integer educationInfo;

    /**
     * 婚姻状态，详见字典说明
     */
    private Integer marriageInfo;

}
