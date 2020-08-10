package cn.com.glsx;

import cn.com.payu.Application;
import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.loans.service.LoansApiService;
import cn.com.payu.modules.loans.service.LoansBizService;
import com.alibaba.fastjson.JSON;
import com.glsx.plat.redis.service.GainIdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

    @Autowired
    private LoansApiService loansApiService;

    @Autowired
    private LoansConfig loansConfig;

    @Autowired
    private LoansBizService loansBizService;

    @Autowired
    private GainIdService gainIdService;

    @Test
    public void test1() {
        BasicsGetLoansProductsResp resp = loansApiService.basicsGetLoansProducts(new BasicsGetLoansProductsReq());
        System.out.println(resp);

//        {
//            "maxAmount":30,
//                "minAmount":1,
//                "minPeriod":1,
//                "productId":13,
//                "productName":"店融易合作产品"
//        },
//        {
//            "maxAmount":30,
//                "minAmount":3,
//                "minPeriod":1,
//                "productId":14,
//                "productName":"趣融合作产品"
//        }
    }

    @Test
    public void test2() {
        BasicsGetLoansPeriodsResp resp = loansApiService.basicsGetLoansPeriods(new BasicsGetLoansPeriodsReq());
        System.out.println(resp);

//        {
//            "6":"6月",
//            "9":"9月",
//            "12":"12月"
//        }
    }

    @Test
    public void test3() {
        BasicsGetHousingTypesResp resp = loansApiService.basicsGetHousingTypes(new BasicsGetHousingTypesReq());
        System.out.println(resp);

//        {
//            "1":"租用",
//            "2":"商业按揭",
//            "3":"公积金按揭房",
//            "4":"无按揭房",
//            "5":"自建房",
//            "6":"亲属住房",
//            "7":"单位宿舍"
//        }
    }

    @Test
    public void test4() {
        BasicsGetTogetherDwellListResp resp = loansApiService.basicsGetTogetherDwellList(new BasicsGetTogetherDwellListReq());
        System.out.println(resp);

//        {
//            "1":"父母",
//            "2":"兄弟姐妹",
//            "3":"子女",
//            "4":"其他亲属",
//            "5":"同事",
//            "6":"朋友",
//            "7":"其他",
//            "8":"独居"
//        }
    }

    @Test
    public void test5() {
        BasicsGetRelationTypelListResp resp = loansApiService.basicsGetRelationTypelList(new BasicsGetRelationTypelListReq());
        System.out.println(resp);

//        {
//            "1":"父母",
//            "2":"子女",
//            "3":"兄妹",
//            "4":"其他亲属",
//            "5":"同事",
//            "6":"朋友",
//            "7":"其他",
//            "8":"配偶"
//        }
    }

    @Test
    public void test6() {
        BasicsGetLoanPurposeListResp resp = loansApiService.basicsGetLoanPurposeList(new BasicsGetLoanPurposeListReq());
        System.out.println(resp);

//        {
//            "1":"日常消费",
//            "2":"生产经营",
//            "3":"购房",
//            "4":"购车",
//            "5":"装修",
//            "6":"教育",
//            "7":"旅游",
//            "8":"周转",
//            "9":"其他"
//        }
    }

    @Test
    public void test7() {
        BasicsGetEducationListResp resp = loansApiService.basicsGetEducationList(new BasicsGetEducationListReq());
        System.out.println(resp);

//        {
//            "1":"硕士及以上",
//            "2":"本科",
//            "3":"大专",
//            "4":"高中",
//            "5":"高中以下"
//        }
    }

    @Test
    public void test8() {
        BasicsGetMarriageListResp resp = loansApiService.basicsGetMarriageList(new BasicsGetMarriageListReq());
        System.out.println(resp);

//        {
//            "1":"未婚",
//            "2":"离异",
//            "3":"丧偶",
//            "4":"已婚"
//        }
    }

    @Test
    public void test9() {
        BasicsGetUnitTypeListResp resp = loansApiService.basicsGetUnitTypeList(new BasicsGetUnitTypeListReq());
        System.out.println(resp);

//        {
//            "1":"国有",
//            "2":"民营",
//            "3":"外资",
//            "4":"合资",
//            "5":"私营",
//            "6":"个体"
//        }
    }

    @Test
    public void test10() {
        BasicsGetIndustryTypeListReq req = new BasicsGetIndustryTypeListReq();
        req.setPid(3);
        BasicsGetIndustryTypeListResp resp = loansApiService.basicsGetIndustryTypeList(req);
        System.out.println(resp);

//        [
//        {
//            "industryId":1,
//                "industryName":"计算机/互联网/通信/电子"
//        },
//        {
//            "industryId":2,
//                "industryName":"房地产"
//        },
//        {
//            "industryId":3,
//                "industryName":"金融业"
//        },
//        {
//            "industryId":4,
//                "industryName":"建筑业"
//        },
//        {
//            "industryId":5,
//                "industryName":"制造业"
//        },
//        {
//            "industryId":6,
//                "industryName":"农林牧渔"
//        },
//        {
//            "industryId":7,
//                "industryName":"批发/零售/贸易"
//        },
//        {
//            "industryId":8,
//                "industryName":"专业服务"
//        },
//        {
//            "industryId":9,
//                "industryName":"文化/体育/娱乐"
//        },
//        {
//            "industryId":10,
//                "industryName":"交通运输/仓储/物流"
//        },
//        {
//            "industryId":11,
//                "industryName":"能源/环保/矿产"
//        },
//        {
//            "industryId":12,
//                "industryName":"教育培训/科研"
//        },
//        {
//            "industryId":13,
//                "industryName":"卫生及社会工作"
//        },
//        {
//            "industryId":14,
//                "industryName":"公共管理/社会保障"
//        },
//        {
//            "industryId":15,
//                "industryName":"生活服务"
//        }
//	]
    }

    @Test
    public void testBasic() {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    @Test
    public void test11() {
        ApplymentIndexReq req = new ApplymentIndexReq();

        String orderNumber = gainIdService.gainId("B");
        req.setOrderNumber(orderNumber);

        ApplymentIndexPersonal personal = new ApplymentIndexPersonal();
        personal.setName("薛倩");
        personal.setGender(1);
        personal.setCertificateType(1);
        personal.setCertificateNumber("450681199904105960");
        personal.setPhoneNumber("13475804735");
        personal.setEmail("levphon@vip.qq.com");
        personal.setEducationInfo(2);
        personal.setMarriageInfo(1);

//        薛倩	450681199904105960	13475804735
//        金雪	330522197008085824	13464978389
//        吴青	440983198811160330	15028316646
//        鲍宜	441223197611100140	15827965427
//        钱妹	511502199309126229	18817131189
//        杨露	360922197111212067	13257305124
//        彭馥	511600198711064765	15340484023
//        皮璐	530629197810107768	13003177433
//        史琦	422825198702249124	17675822599
//        周亚	632622198311151516	18766635159
//        袁霭	520622198204241340	13093716235
//        康馥	360881199007252839	13391770515
//        罗竹	130527198603281415	15288704899
//        平瑗	150422199709127003	13419423879
//        郎姬	21072619770826219X	13782190425
//        俞巧	542624198811075389	18738825126
//        鲁萍	441523199511111905	13106190354
//        凤莎	210111199702170878	13526831294
//        魏琦	370784199002066549	13707864431
//        皮卿	410622199109227486	15617907471
//        任霞	511132198912102872	15965224928
//        喻影	150124197809163076	13371657161
//        沈梦	330682198404266850	15612079632
//        傅瑾	141000198305153429	15018306858
//        戚育	620100199205017239	14788213871
//        元雅	41018319860524661X	17762438606
//        方雁	632522197705181945	13889954463
//        余珍	140107197302044707	15678228517

        ApplymentIndexAddress address = new ApplymentIndexAddress();
        address.setTogetherDwell(1);
        address.setHousingType(2);
        address.setLiveDate(System.currentTimeMillis());
        address.setMonthRent(new BigDecimal("3265"));
        address.setPresentProvince("广东省");
        address.setPresentCity("深圳市");
        address.setPresentRegion("南山区");
        address.setPresentAddress("沙河西路");

        ApplymentIndexJob job = new ApplymentIndexJob();
        job.setBusinessType(1);
        job.setCompanyName("杜拉拉");
        job.setOperateTime(System.currentTimeMillis());
        job.setIndustryCode(String.valueOf(21));
        job.setContactNumber("0755-6546562");
        job.setMonthTurnover(new BigDecimal("6596536"));
        job.setOperateAddress("广东深圳南山智园");
        job.setHiredTime(System.currentTimeMillis());
        job.setStation("工程师");
        job.setWage(new BigDecimal(12345));
        job.setUnitType(2);

        List<ApplymentIndexContact> contactData = new ArrayList<>();
        ApplymentIndexContact contact1 = new ApplymentIndexContact();
        contact1.setContactName("张三1");
        contact1.setRelation(6);
        contact1.setContactNumber("15965224921");
        contact1.setIsKnow(1);

        ApplymentIndexContact contact2 = new ApplymentIndexContact();
        contact2.setContactName("张三2");
        contact2.setRelation(6);
        contact2.setContactNumber("15965224922");
        contact2.setIsKnow(1);

        ApplymentIndexContact contact3 = new ApplymentIndexContact();
        contact3.setContactName("张三3");
        contact3.setRelation(6);
        contact3.setContactNumber("15965224923");
        contact3.setIsKnow(1);
        contactData.add(contact1);
        contactData.add(contact2);
        contactData.add(contact3);

        //incomeData	是	array		收入信息，多维数组(非必填，但对私和对公必须选1个，若无法区分对私和对公时，可统一上传到对私流水信息)
        ApplymentIndexIncome indexIncome = new ApplymentIndexIncome();

        ApplymentIndexIncomePrivate incomePrivate = new ApplymentIndexIncomePrivate();
        incomePrivate.setNearlyOneMonth(26526F);
        incomePrivate.setNearlyTwoMonth(26526F);
        incomePrivate.setNearlyThirdMonth(26526F);
        incomePrivate.setNearlyFourMonth(26526F);
        incomePrivate.setNearlyFiveMonth(26526F);
        incomePrivate.setNearlySixMonth(26526F);
        incomePrivate.setInterestAmount(26526F);
        indexIncome.setPrivateIncome(incomePrivate);

//        List<ApplymentIndexSocial> socialData = new ArrayList<>();
//        List<ApplymentIndexProvidentFund> providentFundData = new ArrayList<>();

        ApplymentIndexDocument document = new ApplymentIndexDocument();
        document.setIdCardFront("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596692254111&di=581b29a00f3d37e7345da74792eacf29&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic%2Fcover%2F00%2F15%2F96%2F57a1991e016dc_610.jpg");
        document.setIdCardBack("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596692254111&di=581b29a00f3d37e7345da74792eacf29&imgtype=0&src=http%3A%2F%2Fpic.51yuansu.com%2Fpic%2Fcover%2F00%2F15%2F96%2F57a1991e016dc_610.jpg");

        ApplymentIndexPedestrian pedestrian = new ApplymentIndexPedestrian();
        pedestrian.setAccount("6565656546");
        pedestrian.setPassword("123456");
        pedestrian.setAuthorizationCode("3594");
        pedestrian.setExpiredTime(System.currentTimeMillis());

        ApplymentIndexLoan loan = new ApplymentIndexLoan();
        loan.setProductId(13);
        loan.setAnnuity(24000);
        loan.setLoanPurpose(4);
        loan.setLoanPeriod(12);
        loan.setMerchantRate(3.8F);
        loan.setPayMethod(2);

        req.setPersonalData(personal);
        req.setAddressData(address);
        req.setJobData(job);
        req.setContactData(contactData);
        req.setIncomeData(indexIncome);
        req.setDocumentData(document);
        req.setPedestrianData(pedestrian);
        req.setLoanData(loan);

        ApplymentIndexResp resp = loansApiService.applymentIndex(req);
        System.out.println(resp);
    }

    @Test
    public void test13() {
        ApplymentGetSignStateReq req = new ApplymentGetSignStateReq();
        req.setOrderNumber("B20200810165759000022");
        ApplymentGetSignStateResp resp = loansApiService.applymentGetSignState(req);
        System.out.println(resp);
    }

    @Test
    public void test12() {
        ApplymentRejectResp resp = loansApiService.applymentReject(new ApplymentRejectReq());
        System.out.println(resp);
    }

    @Test
    public void test14() {
        ApplymentQueryOrderReq req = new ApplymentQueryOrderReq();
        req.setOrderNumber("B20200810165759000022");
        ApplymentQueryOrderResp resp = loansApiService.applymentQueryOrder(req);
        System.out.println(resp);
    }

    @Test
    public void test15() {
        ApplymentQueryPlansReq req = new ApplymentQueryPlansReq();
        req.setOrderNumber("B20200810165759000022");
        ApplymentQueryPlansResp resp = loansApiService.applymentQueryplans(req);
        System.out.println(resp);
    }

    @Test
    public void test16() {
        EsignSigncontractResp resp = loansApiService.esignSigncontract(new EsignSigncontractReq());
        System.out.println(resp);
    }

    @Test
    public void test17() {
        EsignMycontractResp resp = loansApiService.esignMycontract(new EsignMycontractReq());
        System.out.println(resp);
    }

    @Test
    public void test18() {
        EsignGetSignUrlReq req = new EsignGetSignUrlReq();
        req.setOrderNumber("orderNumber");
        req.setSignType(1);
        EsignGetSignUrlResp resp = loansApiService.esignGetSignUrl(req);
        System.out.println(resp);
    }

    @Test
    public void test19() {
        PayGetBanklistResp resp = loansApiService.payGetbanklist(new PayGetBanklistReq());
        System.out.println(resp);
    }

    @Test
    public void test20() {
        PayPretiedcardReq req = new PayPretiedcardReq();
        req.setAccountName("薛倩");
        req.setAccountNo("6228480215110121391");
        req.setIdcardNo("450681199904105960");
        req.setMobile("13475804735");
        req.setOrderNumber("B34938953898539");
        log.info("请求参数: {}", JSON.toJSONString(req, true));
        PayPretiedcardResp resp = loansApiService.payPretiedcard(new PayPretiedcardReq());
        System.out.println(resp);
    }

    @Test
    public void test21() {
        PayConfirmbindcardReq req = new PayConfirmbindcardReq();
        req.setAccountNo("6228480215110121391");
        req.setAccountName("薛倩");
        req.setIdcardNo("450681199904105960");
        req.setBranchName("aaa");
        req.setMobile("13475804735");
        req.setUniqueCode("aaa");
        req.setSmsCode("654465");
        req.setOrderNumber("B34938953898539");
        log.info("请求参数: {}", JSON.toJSONString(req, true));
        PayConfirmbindcardResp resp = loansApiService.payConfirmbindcard(req);
        System.out.println(resp);
    }

    @Test
    public void test22() {
        PayQueryWithholdResp resp = loansApiService.payQuerywithhold(new PayQueryWithholdReq());
        System.out.println(resp);
    }

    @Test
    public void test23() {
        PayGetPayInfoResp resp = loansApiService.payGetPayInfo(new PayGetPayInfoReq());
        System.out.println(resp);
    }

    @Test
    public void test24() {
        ApplymentIndexCallbackReq req = new ApplymentIndexCallbackReq();
        req.setCallbackNumber("983958384385335");
        req.setCallbackType(1);
        req.setOrderNumber("B20200807175339000010");
        req.setApplyNumber("989839859839853");
        req.setDescription("this is a desc");
        req.setReason("this is a reason");
        req.setSign("sign");
        log.info("请求参数: {}", JSON.toJSONString(req, true));
        int rtnCode = loansBizService.applymentIndexCallback(req);
        System.out.println(rtnCode);
    }

    @Test
    public void test26() {
        PayWithholdCallbackReq req = new PayWithholdCallbackReq();
        req.setCallbackNumber("0294839583953");
        req.setCallbackType(1);
        req.setOrderNumber("8785938598353");
        req.setApplyNumber("B20200807175339000010");
        req.setPeriodOrder(1);
        req.setIsFinish(false);
        req.setDescription("this is a desc");
        req.setReason("this is a reason");
        req.setSign("sign");
        log.info("请求参数: {}", JSON.toJSONString(req, true));
        int rtnCode = loansBizService.payWithholdCallback(req);
        System.out.println(rtnCode);
    }


    @Test
    public void testIds() {
        String s1 = gainIdService.gainId("B");
        String s2 = gainIdService.globalUniqueId("B");
        System.out.println(s1);
        System.out.println(s2);
    }
}