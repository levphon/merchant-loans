package cn.com.payu.modules.model.search;

import cn.hutool.db.Page;
import lombok.Data;

@Data
public class ReportSearch extends Page {

    /**
     * 开始时间
     */
    private String sDate;

    /**
     * 结束时间
     */
    private String eDate;

}
