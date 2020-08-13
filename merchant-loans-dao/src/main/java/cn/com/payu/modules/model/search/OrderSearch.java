package cn.com.payu.modules.model.search;

import cn.hutool.db.Page;
import lombok.Data;

@Data
public class OrderSearch extends Page {

    private String orderNumber;

    private Integer loanStatus;

    private String sDate;
    private String eDate;

}
