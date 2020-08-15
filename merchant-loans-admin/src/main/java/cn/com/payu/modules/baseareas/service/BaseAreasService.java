package cn.com.payu.modules.baseareas.service;

import cn.com.payu.common.constant.ConstantCacheKeys;
import cn.com.payu.modules.entity.BaseArea;
import cn.com.payu.modules.mapper.BaseAreaMapper;
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
public class BaseAreasService {

    @Resource
    private BaseAreaMapper areaMapper;

    @Autowired
    private RedisUtils redisUtils;

    public List<BaseArea> searchByCityCode(String cityCode) {
        List<BaseArea> list = null;//redisUtils.getListByPrex(ConstantCacheKeys.REDIS_AREA_KEY + cityCode);
//        Collections.sort(list, Comparator.comparing(BaseArea::getCode));
        if (CollectionUtils.isEmpty(list)) list = areaMapper.selectByCityCode(cityCode);
        return list;
    }

}
