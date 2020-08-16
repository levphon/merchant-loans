package cn.com.payu.modules.model.export;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderExport {

    @ExcelIgnore
    private Long id;

    @ExcelProperty(value = "订单编号", index = 0)
    private String orderNumber;

    @ExcelProperty(value = "业务员编号", index = 1)
    private String salesmanNo;

    @ExcelProperty(value = "客户名称", index = 2)
    private String name;

    @ExcelProperty(value = "客户证件号", index = 3)
    private String certificateNumber;

    @ExcelProperty(value = "客户手机号", index = 4)
    private String phoneNumber;

    @ExcelProperty(value = "借款额度", index = 5)
    private Integer annuity;

    @ExcelProperty(value = "借款期数", index = 6)
    private Integer loanPeriod;

    @ExcelIgnore
    private Integer auditAmount;
    @ExcelIgnore
    private Integer auditPeriod;

    @ExcelIgnore
    private Integer loanStatus;

    @ExcelProperty(value = "进件放款状态", index = 7)
    private String loanStatusDesc;

    @ExcelProperty(value = "银行卡号", index = 8)
    private String accountNo;

    @ExcelIgnore
    private Integer bindStatus;

    @ExcelProperty(value = "绑卡状态", index = 9)
    private String bindStatusDesc;

    @ExcelIgnore
    private Integer repayStatus;

    @ExcelProperty(value = "还款状态", index = 10)
    private String repayStatusDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "创建时间", index = 11)
    private Date createdDate;

}
