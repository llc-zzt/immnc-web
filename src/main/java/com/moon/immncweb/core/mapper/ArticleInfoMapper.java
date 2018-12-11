package com.moon.immncweb.core.mapper;

import com.baomidou.mybatisplus.annotations.SqlParser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Mapper
@Repository
public interface ArticleInfoMapper extends BaseMapper<ArticleInfo> {
    @Update("update `article_info` SET `search_num`= `search_num`+1 where `article_id` = #{articleId} ")
    void updateTopNum(String articleId);
}
