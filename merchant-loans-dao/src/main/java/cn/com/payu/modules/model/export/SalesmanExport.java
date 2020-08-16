package cn.com.payu.modules.model.export;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SalesmanExport {

    @ExcelProperty(value = "业务员名称", index = 0)
    private String name;

    @ExcelProperty(value = "业务员编号", index = 1)
    private String jobNo;

    @ExcelProperty(value = "手机号码", index = 2)
    private String phone;

    @ExcelProperty(value = "省份", index = 3)
    private String prov;

    @ExcelProperty(value = "城市", index = 4)
    private String city;

    @ExcelProperty(value = "县区", index = 5)
    private String area;

    @ExcelProperty(value = "地址", index = 6)
    private String address;

    @ExcelIgnore
    private Integer enableStatus;
    @ExcelProperty(value = "启用状态", index = 7)
    private String enableStatusDesc;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "创建时间", index = 8)
    private Date createdDate;

}
