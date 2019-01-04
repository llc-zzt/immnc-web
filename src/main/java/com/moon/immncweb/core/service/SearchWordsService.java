package com.moon.immncweb.core.service;

import com.moon.immncweb.core.entity.SearchWords;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/12/28
 * @Desc
 */
public interface SearchWordsService {

    /**
     * 从大到小排列 热搜关键字
     * @return
     */
    List<SearchWords> listSearchWordCountDesc();

    /**
     * 插入热搜词
     * @param content
     */
    void insertWords(String content);

}
