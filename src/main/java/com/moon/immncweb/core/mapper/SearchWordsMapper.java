package com.moon.immncweb.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.moon.immncweb.core.entity.CommentPraise;
import com.moon.immncweb.core.entity.SearchWords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Mapper
@Repository
public interface SearchWordsMapper extends BaseMapper<SearchWords> {

    @Update("update `search_words` set `search_count` = `search_count` +1 WHERE `content` = #{content}")
    void updateSearchNumByContent(String content);
    @Select("select * from `search_words` ORDER BY `search_count` DESC LIMIT 0,10")
    List<SearchWords> listSearchWordCountDesc();
}
