package cn.com.payu.modules.loans.req;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class ApplymentIndexReq extends AbstractApiReq {

    /**
     * 业务员
     */
    @Expose
    private String salesman;

    /**
     * 商户订单号
     */
    private String orderNumber;

    /**
     * 个人基本信息
     */
    private ApplymentIndexPersonal personalData;

    /**
     * 住址信息
     */
    private ApplymentIndexAddress addressData;

    /**
     * 工作单位信息
     */
    private ApplymentIndexJob jobData;

    /**
     * 联系人信息 必须3个联系人以上(含3个)，已婚时：配偶信息必须完整：身份证、工作单位、单位地址、现地址(配偶若无工作按实际情况填写即可)，一般联系人：身份证、工作单位、单位地址、现地址非必填项，其他字段为必填项
     */
    private List<ApplymentIndexContact> contactData;

    /**
     * 收入信息，多维数组(非必填，但对私和对公必须选1个，若无法区分对私和对公时，可统一上传到对私流水信息)
     */
    private ApplymentIndexIncome incomeData;

    /**
     * 社保信息(非必填)
     */
    private ApplymentIndexSocial socialData;

    /**
     * 公积金信息(非必填)
     */
    private ApplymentIndexProvidentFund providentFundData;

    /**
     * 文件相关资料
     */
    private ApplymentIndexDocument documentData;

    /**
     * 人行征信信息
     */
    private ApplymentIndexPedestrian pedestrianData;

    /**
     * 贷款相关信息
     */
    private ApplymentIndexLoan loanData;

    /**
     * 客户店铺信息，非必传，若上传则必须上传每个字段
     */
    private ApplymentIndexShop shopData;

}
