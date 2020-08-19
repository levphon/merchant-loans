package cn.com.payu.modules.customer.controller;

import cn.com.payu.modules.BaseController;
import cn.com.payu.modules.loans.service.LoansBizService;
import cn.com.payu.modules.model.LoanRecordDetails;
import cn.com.payu.modules.model.LoanRecordModel;
import cn.com.payu.modules.model.RepayIn7DayDetails;
import cn.com.payu.modules.model.RepayIn7DaysModel;
import com.glsx.plat.core.web.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/my")
public class MyController extends BaseController {

    @Autowired
    private LoansBizService loansBizService;

    @GetMapping(value = "/loanlist")
    public R loanList() {
        List<LoanRecordModel> list = loansBizService.loanList(getAccount());
        return R.ok().data(list);
    }

    @GetMapping(value = "/loanlist/details")
    public R loanListDetails(@RequestParam Long loanId) {
        LoanRecordDetails details = loansBizService.loanListDetails(loanId);
        return R.ok().data(details);
    }

    @GetMapping(value = "/repayIn7days")
    public R repayIn7days() {
        List<RepayIn7DaysModel> list = loansBizService.repayIn7days(getAccount());
        return R.ok().data(list);
    }

    @GetMapping(value = "/repayIn7days/details")
    public R repayIn7daysDetails(@RequestParam Long loanId) {
        List<RepayIn7DayDetails> list = loansBizService.repayIn7daysDetails(getAccount());
        return R.ok().data(list);
    }
}
