package cn.com.payu.modules.basecities.service;

import cn.com.payu.common.constant.ConstantCacheKeys;
import cn.com.payu.modules.entity.BaseCity;
import cn.com.payu.modules.mapper.BaseCityMapper;
import com.glsx.plat.redis.utils.RedisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


@Service
public class BaseCitiesService {

    @Resource
    private BaseCityMapper cityMapper;

    @Autowired
    private RedisUtils redisUtils;

    public List<BaseCity> list(Map<String, String> params) {
        String provinceCode = params.get("provinceCode");
        List<BaseCity> list = null;//redisUtils.getListByPrex(ConstantCacheKeys.REDIS_CITY_KEY + provinceCode);
//        Collections.sort(list, Comparator.comparing(BaseCity::getCode));

        BaseCity city = new BaseCity();
        city.setProvinceCode(provinceCode);
        if (CollectionUtils.isEmpty(list)) list = cityMapper.selectByExample(city);
        return list;
    }
}
