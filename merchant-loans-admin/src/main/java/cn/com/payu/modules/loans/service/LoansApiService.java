package cn.com.payu.modules.loans.service;

import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.*;
import cn.com.payu.modules.loans.resp.*;
import cn.com.payu.modules.loans.util.AccessUtils;
import com.alibaba.fastjson.JSON;
import com.glsx.plat.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author payu
 */
@Slf4j
@Service
public class LoansApiService {

    @Autowired
    private LoansConfig config;

    @Autowired
    private AccessUtils accessUtils;

    public ApplymentIndexResp applymentIndex(ApplymentIndexReq req) {
        log.info("【商户贷——进件申请】请求参数: {}", JSON.toJSONString(req, true));
        ApplymentIndexResp resp = accessUtils.accessByPost(config.getApplymentIndexUrl(), req, ApplymentIndexResp.class);
        log.info("【商户贷——进件申请】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public ApplymentRejectResp applymentReject(ApplymentRejectReq req) {
        log.info("【商户贷——进件驳回】请求参数: {}", JSON.toJSONString(req, true));
        ApplymentRejectResp resp = accessUtils.accessByPost(config.getApplymentRejectUrl(), req, ApplymentRejectResp.class);
        log.info("【商户贷——进件驳回】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public ApplymentGetSignStateResp applymentGetSignState(ApplymentGetSignStateReq req) {
        log.info("【商户贷——查询签署状态】请求参数: {}", JSON.toJSONString(req, true));
        ApplymentGetSignStateResp resp = accessUtils.accessByPost(config.getApplymentGetSignStateUrl(), req, ApplymentGetSignStateResp.class);
        log.info("【商户贷——查询签署状态】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public ApplymentQueryOrderResp applymentQueryOrder(ApplymentQueryOrderReq req) {
        log.info("【商户贷——进件查询】请求参数: {}", JSON.toJSONString(req, true));
        ApplymentQueryOrderResp resp = accessUtils.accessByPost(config.getApplymentQueryOrderUrl(), req, ApplymentQueryOrderResp.class);
        log.info("【商户贷——进件查询】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public ApplymentQueryPlansResp applymentQueryplans(ApplymentQueryPlansReq req) {
        log.info("【商户贷——查询还款计划】请求参数: {}", JSON.toJSONString(req, true));
        ApplymentQueryPlansResp resp = accessUtils.accessByPost(config.getApplymentQueryplansUrl(), req, ApplymentQueryPlansResp.class);
        log.info("【商户贷——查询还款计划】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public PayGetBanklistResp payGetbanklist(PayGetBanklistReq req) {
        log.info("【商户贷——获取绑定银行卡列表】请求参数: {}", JSON.toJSONString(req, true));
        PayGetBanklistResp resp = accessUtils.accessByPost(config.getPayGetBanklistUrl(), req, PayGetBanklistResp.class);
        log.info("【商户贷——获取绑定银行卡列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public PayPretiedcardResp payPretiedcard(PayPretiedcardReq req) {
        log.info("【商户贷——预绑卡操作】请求参数: {}", JSON.toJSONString(req, true));
        PayPretiedcardResp resp = accessUtils.accessByPost(config.getPayPretiedcardUrl(), req, PayPretiedcardResp.class);
        log.info("【商户贷——预绑卡操作】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public PayConfirmbindcardResp payConfirmbindcard(PayConfirmbindcardReq req) {
        log.info("【商户贷——确定绑卡操作】请求参数: {}", JSON.toJSONString(req, true));
        PayConfirmbindcardResp resp = accessUtils.accessByPost(config.getPayConfirmbindcardUrl(), req, PayConfirmbindcardResp.class);
        log.info("【商户贷——确定绑卡操作】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public PayQueryWithholdResp payQuerywithhold(PayQueryWithholdReq req) {
        log.info("【商户贷——代扣操作结果查询】请求参数: {}", JSON.toJSONString(req, true));
        PayQueryWithholdResp resp = accessUtils.accessByPost(config.getPayQuerywithholdUrl(), req, PayQueryWithholdResp.class);
        log.info("【商户贷——代扣操作结果查询】响应数据: {}", JSON.toJSONString(resp, true));
//        checkRespResult(resp);
        return resp;
    }

    public PayGetPayInfoResp payGetPayInfo(PayGetPayInfoReq req) {
        log.info("【商户贷——查询借款的还款信息】请求参数: {}", JSON.toJSONString(req, true));
        PayGetPayInfoResp resp = accessUtils.accessByPost(config.getPayGetPayInfoUrl(), req, PayGetPayInfoResp.class);
        log.info("【商户贷——查询借款的还款信息】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public EsignSigncontractResp esignSigncontract(EsignSigncontractReq req) {
        log.info("【商户贷——一键签约】请求参数: {}", JSON.toJSONString(req, true));
        EsignSigncontractResp resp = accessUtils.accessByPost(config.getEsignSigncontractUrl(), req, EsignSigncontractResp.class);
        log.info("【商户贷——一键签约】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public EsignMycontractResp esignMycontract(EsignMycontractReq req) {
        log.info("【商户贷——获取我的合同】请求参数: {}", JSON.toJSONString(req, true));
        EsignMycontractResp resp = accessUtils.accessByPost(config.getEsignMycontractUrl(), req, EsignMycontractResp.class);
        log.info("【商户贷——获取我的合同】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public EsignGetSignUrlResp esignGetSignUrl(EsignGetSignUrlReq req) {
        log.info("【商户贷——获取签署地址】请求参数: {}", JSON.toJSONString(req, true));
        EsignGetSignUrlResp resp = accessUtils.accessByPost(config.getEsignGetSignUrl(), req, EsignGetSignUrlResp.class);
        log.info("【商户贷——获取签署地址】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetLoansProductsResp basicsGetLoansProducts(BasicsGetLoansProductsReq req) {
        log.info("【商户贷——获取贷款产品】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetLoansProductsResp resp = accessUtils.accessByPost(config.getBasicsGetLoansProductsUrl(), req, BasicsGetLoansProductsResp.class);
        log.info("【商户贷——获取贷款产品】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetLoansPeriodsResp basicsGetLoansPeriods(BasicsGetLoansPeriodsReq req) {
        log.info("【商户贷——获取贷款期限】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetLoansPeriodsResp resp = accessUtils.accessByPost(config.getBasicsGetLoansPeriodsUrl(), req, BasicsGetLoansPeriodsResp.class);
        log.info("【商户贷——获取贷款期限】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetHousingTypesResp basicsGetHousingTypes(BasicsGetHousingTypesReq req) {
        log.info("【商户贷——获取住宅类型】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetHousingTypesResp resp = accessUtils.accessByPost(config.getBasicsGethousingTypesUrl(), req, BasicsGetHousingTypesResp.class);
        log.info("【商户贷——获取住宅类型】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetTogetherDwellListResp basicsGetTogetherDwellList(BasicsGetTogetherDwellListReq req) {
        log.info("【商户贷——获取客户的与谁居住字段的选择列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetTogetherDwellListResp resp = accessUtils.accessByPost(config.getBasicsGetTogetherDwellListUrl(), req, BasicsGetTogetherDwellListResp.class);
        log.info("【商户贷——获取客户的与谁居住字段的选择列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetRelationTypelListResp basicsGetRelationTypelList(BasicsGetRelationTypelListReq req) {
        log.info("【商户贷——获取联系人关系的选择列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetRelationTypelListResp resp = accessUtils.accessByPost(config.getBasicsGetRelationTypelListUrl(), req, BasicsGetRelationTypelListResp.class);
        log.info("【商户贷——获取联系人关系的选择列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetLoanPurposeListResp basicsGetLoanPurposeList(BasicsGetLoanPurposeListReq req) {
        log.info("【商户贷——获取贷款用途的选择列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetLoanPurposeListResp resp = accessUtils.accessByPost(config.getBasicsGetLoanPurposeListUrl(), req, BasicsGetLoanPurposeListResp.class);
        log.info("【商户贷——获取贷款用途的选择列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetEducationListResp basicsGetEducationList(BasicsGetEducationListReq req) {
        log.info("【商户贷——获取学历列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetEducationListResp resp = accessUtils.accessByPost(config.getBasicsGetEducationListUrl(), req, BasicsGetEducationListResp.class);
        log.info("【商户贷——获取学历列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetMarriageListResp basicsGetMarriageList(BasicsGetMarriageListReq req) {
        log.info("【商户贷——获取婚姻的选择列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetMarriageListResp resp = accessUtils.accessByPost(config.getBasicsGetMarriageListUrl(), req, BasicsGetMarriageListResp.class);
        log.info("【商户贷——获取婚姻的选择列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetUnitTypeListResp basicsGetUnitTypeList(BasicsGetUnitTypeListReq req) {
        log.info("【商户贷——获取单位性质的列表】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetUnitTypeListResp resp = accessUtils.accessByPost(config.getBasicsGetUnitTypeListUrl(), req, BasicsGetUnitTypeListResp.class);
        log.info("【商户贷——获取单位性质的列表】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    public BasicsGetIndustryTypeListResp basicsGetIndustryTypeList(BasicsGetIndustryTypeListReq req) {
        log.info("【商户贷——获取行业类别】请求参数: {}", JSON.toJSONString(req, true));
        BasicsGetIndustryTypeListResp resp = accessUtils.accessByPost(config.getBasicsGetIndustryTypeListUrl(), req, BasicsGetIndustryTypeListResp.class);
        log.info("【商户贷——获取行业类别】响应数据: {}", JSON.toJSONString(resp, true));
        checkRespResult(resp);
        return resp;
    }

    private void checkRespResult(AbstractApiResp resp) {
        if (!"200".equals(resp.getCode()))
            throw BusinessException.create(resp.getCode(), resp.getMsg());
    }

}
