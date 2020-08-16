package cn.com.payu.modules.order.service;

import cn.com.payu.common.enmus.DataDictionary;
import cn.com.payu.common.enmus.LoanStatus;
import cn.com.payu.modules.entity.*;
import cn.com.payu.modules.loans.service.LoansBizService;
import cn.com.payu.modules.mapper.*;
import cn.com.payu.modules.model.OrderModel;
import cn.com.payu.modules.model.export.OrderExport;
import cn.com.payu.modules.model.search.OrderSearch;
import cn.com.payu.modules.order.model.OrderDetailsModel;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private LoanMapper loanMapper;

    @Autowired
    private LoanPersonalMapper loanPersonalMapper;

    @Autowired
    private LoanDocumentMapper loanDocumentMapper;

    @Autowired
    private LoanContactMapper loanContactMapper;

    @Autowired
    private LoanEsignMapper loanEsignMapper;

    @Autowired
    private LoanContractMapper loanContractMapper;

    @Autowired
    private LoanPlansMapper loanPlansMapper;

    @Autowired
    private LoansBizService loansBizService;

    public PageInfo<OrderModel> search(OrderSearch search) {
        List<OrderModel> list = loanMapper.search(search);
        for (OrderModel o : list) {
            o.setLoanStatusDesc(LoanStatus.getNameByCode(o.getLoanStatus()));

            if (o.getBindStatus() == null) o.setBindStatus(DataDictionary.BindStatus.unbound.getCode());
            o.setBindStatusDesc(DataDictionary.BindStatus.getValueByCode(o.getBindStatus()));

            Integer repayStatus = loansBizService.getRepayStatus(o.getId());
            o.setRepayStatus(repayStatus);
            o.setRepayStatusDesc(DataDictionary.RepayStatus.getValueByCode(o.getRepayStatus()));
        }
        return new PageInfo<>(list);
    }

    public List<OrderExport> export(OrderSearch search) {
        List<OrderExport> list = loanMapper.export(search);
        for (OrderExport o : list) {
            o.setLoanStatusDesc(LoanStatus.getNameByCode(o.getLoanStatus()));

            if (o.getBindStatus() == null) o.setBindStatus(DataDictionary.BindStatus.unbound.getCode());
            o.setBindStatusDesc(DataDictionary.BindStatus.getValueByCode(o.getBindStatus()));

            Integer repayStatus = loansBizService.getRepayStatus(o.getId());
            o.setRepayStatus(repayStatus);
            o.setRepayStatusDesc(DataDictionary.RepayStatus.getValueByCode(o.getRepayStatus()));
        }
        return list;
    }


    public OrderDetailsModel getDetailsById(Long loanId) {

        Loan loan = loanMapper.selectByPrimaryKey(loanId);

        LoanPersonal personal = loanPersonalMapper.selectByLoanId(loanId);

        List<LoanDocument> documentList = loanDocumentMapper.selectAllByLoanId(loanId);

        List<LoanContact> contactList = loanContactMapper.selectByLoanId(loanId);

        List<LoanEsign> esignList = loanEsignMapper.selectByLoanId(loanId);

        List<LoanContract> contractList = loanContractMapper.selectByLoanId(loanId);

        OrderDetailsModel model = new OrderDetailsModel();
        model.setLoan(loan);
        model.setPersonal(personal);
        model.setDocumentList(documentList);
        model.setContactList(contactList);
        model.setEsignList(esignList);
        model.setContractList(contractList);
        return model;
    }

    public List<LoanPlans> getRepayPlans(Long loanId) {
        return loanPlansMapper.selectByLoanId(loanId);
    }

    public void logicDeleteById(Integer[] ids) {

    }

}
