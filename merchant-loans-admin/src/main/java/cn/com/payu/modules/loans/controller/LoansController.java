package cn.com.payu.modules.loans.controller;

import cn.com.glsx.admin.services.userservice.model.UserDTO;
import cn.com.payu.modules.loans.service.LoansBizService;
import com.glsx.plat.core.web.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/mloans")
public class LoansController {

    @Autowired
    private LoansBizService loansBizService;

    @GetMapping("/basics/getLoansProducts")
    public R basicsGetLoansProducts() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getLoansPeriods")
    public R basicsGetLoansPeriods() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getHousingTypes")
    public R basicsGethousingTypes() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getTogetherDwellList")
    public R basicsGetTogetherDwellList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getRelationTypelList")
    public R basicsGetRelationTypelList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getLoanPurposeList")
    public R basicsGetLoanPurposeList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getEducationList")
    public R basicsGetEducationList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getMarriageList")
    public R basicsGetMarriageList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getUnitTypeList")
    public R basicsGetUnitTypeList() {
        Object obj = new Object();
        return R.ok().data(obj);

    }

    @GetMapping("/basics/getIndustryTypeList")
    public R basicsGetIndustryTypeList() {
        Object obj = new Object();
        return R.ok().data(obj);
    }

    @PostMapping(value = "/applymentIndex")
    public R applymentIndex(@RequestBody @Valid UserDTO userDTO) {

        return R.ok();
    }

}
