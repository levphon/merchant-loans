package cn.com.payu.modules.loans.req;

import lombok.Data;

@Data
public class ApplymentIndexContact {

    /**
     * 联系人名字
     */
    private String contactName;

    /**
     * 联系人和客户的关系，详见字典说明
     */
    private Integer relation;
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 工作单位
     */
    private String workUnit;

    /**
     * 单位地址
     */
    private String unitAddress;

    /**
     * 现地址
     */
    private String contactAddress;

    /**
     * 否知晓贷款，详见字典说明
     */
    private Integer isKnow;

}
