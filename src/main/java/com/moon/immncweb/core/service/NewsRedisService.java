package com.moon.immncweb.core.service;

import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

/**
 * @Author zhaoxiang
 * @Date 2018/12/05
 * @Desc
 */
@Component
public class NewsRedisService {

    @CacheEvict(cacheNames = "news", key = "#typeId")
    public ResponseVO newsEvict(Integer typeId) {
        return ResponseVO.e(ResponseCode.SUCCESS);
    }

    @CacheEvict(cacheNames = "news", key = "1000")
    public ResponseVO bannerEvict() {
        return ResponseVO.e(ResponseCode.SUCCESS);
    }

    @CacheEvict(cacheNames = "classify", key = "1000")
    public ResponseVO classifyEvict() {
        return ResponseVO.e(ResponseCode.SUCCESS);
    }
}
