package cn.com.payu.modules.model.search;

import cn.hutool.db.Page;
import lombok.Data;

@Data
public class SalesmanSearch extends Page {

    private String name;

    private String sDate;
    private String eDate;

}
