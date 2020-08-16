package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_contact")
public class LoanContact extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 联系人名字
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系人和客户的关系，详见字典说明
     */
    private Integer relation;

    /**
     * 身份证号
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 联系电话
     */
    @Column(name = "contact_number")
    private String contactNumber;

    /**
     * 工作单位
     */
    @Column(name = "work_unit")
    private String workUnit;

    /**
     * 单位地址
     */
    @Column(name = "unit_address")
    private String unitAddress;

    /**
     * 现地址
     */
    @Column(name = "contact_address")
    private String contactAddress;

    /**
     * 知晓贷款，详见字典说明
     */
    @Column(name = "is_know")
    private Integer isKnow;

}