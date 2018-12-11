package com.moon.immncweb.core.service;

import com.moon.immncweb.core.entity.Classify;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/27
 * @Desc
 */
public interface ClassifyService {
    /**
     * 从数据库查找所有
     * @return
     */
    List<Classify> findAllToDB();
}
