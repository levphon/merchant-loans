package cn.com.payu.modules.order.service;

import cn.com.payu.modules.mapper.LoanMapper;
import cn.com.payu.modules.model.OrderModel;
import cn.com.payu.modules.model.export.OrderExport;
import cn.com.payu.modules.model.search.OrderSearch;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private LoanMapper loanMapper;

    public PageInfo<OrderModel> search(OrderSearch search) {
        List<OrderModel> list = loanMapper.search(search);
        final PageInfo<OrderModel> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public List<OrderExport> export(OrderSearch search) {
        List<OrderExport> list = loanMapper.export(search);
        return list;
    }

}
