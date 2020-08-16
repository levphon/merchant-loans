package cn.com.payu.modules.entity;

import com.glsx.plat.mybatis.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "d_loan_esign")
public class LoanEsign extends BaseEntity {

    /**
     * 借款id
     */
    @Column(name = "loan_id")
    private Long loanId;

    /**
     * 长链地址(永久有效)
     */
    private String url;

    /**
     * 短链地址（30天有效）
     */
    @Column(name = "short_url")
    private String shortUrl;

    /**
     * 电子签类型：1授权书，2电子合同
     */
    private Integer type;

}