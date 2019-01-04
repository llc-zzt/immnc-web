package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.core.entity.SearchWords;
import com.moon.immncweb.core.mapper.SearchWordsMapper;
import com.moon.immncweb.core.service.SearchWordsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @Author zhaoxiang
 * @Date 2018/12/28
 * @Desc
 */
@Service
@Transactional
public class SearchWordsServiceImpl extends ServiceImpl<SearchWordsMapper, SearchWords> implements SearchWordsService {

    @Override
    public List<SearchWords> listSearchWordCountDesc() {
        return this.baseMapper.listSearchWordCountDesc();
    }

    @Override
    public void insertWords(String content) {
        SearchWords result = this.selectOne(new EntityWrapper<SearchWords>().eq("content",content));
        if (result == null) {
            SearchWords newInsert = new SearchWords();
            newInsert.setContent(content);
            newInsert.setSearchCount(new Random().nextInt(100));
            this.insert(newInsert);
        }
        this.baseMapper.updateSearchNumByContent(content);

    }
}
