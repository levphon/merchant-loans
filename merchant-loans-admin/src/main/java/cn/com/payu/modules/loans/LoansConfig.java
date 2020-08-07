package cn.com.payu.modules.loans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author payu
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "loans")
public class LoansConfig {

    private String merId;

    private String secret;

    private String salt;

    private String apiUrl;

    private String applymentIndexUrl;
    private String applymentRejectUrl;
    private String applymentGetSignStateUrl;
    private String applymentQueryOrderUrl;
    private String applymentQueryplansUrl;

    private String payGetBanklistUrl;
    private String payPretiedcardUrl;
    private String payConfirmbindcardUrl;
    private String payQuerywithholdUrl;
    private String payGetPayInfoUrl;

    private String esignSigncontractUrl;
    private String esignMycontractUrl;
    private String esignGetSignUrl;

    private String basicsGetLoansProductsUrl;
    private String basicsGetLoansPeriodsUrl;
    private String basicsGethousingTypesUrl;
    private String basicsGetTogetherDwellListUrl;
    private String basicsGetRelationTypelListUrl;
    private String basicsGetLoanPurposeListUrl;
    private String basicsGetEducationListUrl;
    private String basicsGetMarriageListUrl;
    private String basicsGetUnitTypeListUrl;
    private String basicsGetIndustryTypeListUrl;

}
