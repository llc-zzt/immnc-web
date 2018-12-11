package com.moon.immncweb.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Mapper
@Repository
public interface ClassifyMapper extends BaseMapper<Classify> {

}
