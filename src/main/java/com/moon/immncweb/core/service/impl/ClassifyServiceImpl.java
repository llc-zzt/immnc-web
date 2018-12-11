package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.common.exception.APIException;
import com.moon.immncweb.core.entity.Classify;
import com.moon.immncweb.core.mapper.ClassifyMapper;
import com.moon.immncweb.core.service.ClassifyService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/27
 * @Desc
 */
@Service
@CacheConfig(cacheNames = "classify")
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper,Classify> implements ClassifyService {

    @Override
    @Cacheable(key = "1000")
    public List<Classify> findAllToDB() {
        try {
            return this.selectList(new EntityWrapper<>());
        }catch (Exception e){
            throw APIException.fail("数据查询失败",e);
        }

    }
}
