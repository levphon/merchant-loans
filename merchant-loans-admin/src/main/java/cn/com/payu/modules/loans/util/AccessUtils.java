package cn.com.payu.modules.loans.util;

import cn.com.payu.common.exception.ApiException;
import cn.com.payu.modules.loans.LoansConfig;
import cn.com.payu.modules.loans.req.AbstractApiReq;
import cn.com.payu.modules.loans.req.ApplymentIndexReq;
import com.glsx.plat.common.utils.HttpUtils;
import com.glsx.plat.common.utils.SignUtils;
import com.glsx.plat.common.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author payu
 */
@Slf4j
@Component
public class AccessUtils {

    final GsonBuilder builder = new GsonBuilder();
    final Gson gson = builder.create();

    @Resource
    private LoansConfig config;

    /**
     * 调用服务 By GET
     */
    public <T> T accessByGet(String url, Object req, Class<T> clazz) {
        AbstractApiReq param = (AbstractApiReq) req;
        // 1. 补全请求数据
        complementedRequestData(param);
        // 2. 校验请求数据
        verifyRequestData(param);
        // 3. 请求结果
        return call(url, param, clazz);
    }

    /**
     * 调用服务 By POST
     */
    public <T> T accessByPost(String url, Object req, Class<T> clazz) {
        AbstractApiReq param = (AbstractApiReq) req;
        // 1. 补全请求数据
        complementedRequestData(param);
        // 2. 校验请求数据
        verifyRequestData(param);
        // 3. 请求结果
        return call(url, param, clazz);
    }

    /**
     * 补全请求实体—— 补全通用的实体属性,比如appkey属性及sign属性。
     * 也可以通过 instanceof,针对特定请求实体进行补全操作。
     */
    protected void complementedRequestData(AbstractApiReq req) {
        req.setMerId(config.getMerId());
        req.setSign(generateSign(req));
    }

    /**
     * 校验请求实体的通用属性,比如appkey属性及sign属性。
     * 也可以通过 instanceof,针对特定请求实体进行校验操作。
     */
    protected void verifyRequestData(AbstractApiReq req) {
        if (StringUtils.isNullOrEmpty(req.getMerId()) || StringUtils.isNullOrEmpty(req.getSign())) {
            throw ApiException.create("请检查请求参数是否填写完整,必要请求参数缺失.");
        }

        // 针对 日均活跃、行驶、里程 的请求数据进行校验
        if (req instanceof ApplymentIndexReq) {
            ApplymentIndexReq verifyReq = (ApplymentIndexReq) req;
            checkApplymentIndexRequestData(verifyReq);
        }


    }

    /**
     * 必传参数校验
     *
     * @param verifyReq
     */
    protected void checkApplymentIndexRequestData(ApplymentIndexReq verifyReq) {
//        if (CollectionUtils.isEmpty(verifyReq.getStatistics()))
//            throw ApiException.create("请求数据有误，请检查");
    }

    /**
     * 生成签名
     *
     * @param req
     * @return
     */
    protected String generateSign(AbstractApiReq req) {
        String paramsJson = SignUtils.getSignTreeJson(req);
        return SignUtils.sign(config.getSecret(), paramsJson, config.getSalt());
    }

    /**
     * 通过 http+post+json 方式调用服务接口,并获取相应的响应实体.
     */
    @SuppressWarnings({"unchecked"})
    private <T> T call(String url, Object param, Class<T> clazz) {
        String paramsJson = gson.toJson(param);
        log.info("【商户贷】http请求信息—— url[{}] params[{}]", url, paramsJson);
        String result = null;
        try {
            HttpUtils httpUtils = new HttpUtils();
            result = httpUtils.postJson(url, paramsJson);
        } catch (Exception e) {
            log.error("【商户贷】http请求调用发生错误——{}", e.toString());
            throw ApiException.create(url + "请求调用发生错误");
        }
        result = result.replace("\uFEFF", "");
        log.info("【商户贷】http响应信息—— result[{}]", result);
        return gson.fromJson(result, clazz);
    }

}
