package cn.com.payu.modules.order.model;

import cn.com.payu.modules.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsModel {

    private Loan loan;

    private LoanPersonal personal;

    private List<LoanDocument> documentList;

    private List<LoanContact> contactList;

    private List<LoanEsign> esignList;

    private List<LoanContract> contractList;

}
