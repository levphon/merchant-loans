package cn.com.payu.modules.report.model;

import cn.com.payu.modules.model.RowsModel;

import java.util.Comparator;

public class RowsModelComparator implements Comparator<RowsModel> {

    @Override
    public int compare(RowsModel o1, RowsModel o2) {
        return o1.getX().compareTo(o2.getX());
    }

}
