package com.moon.immncweb.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.moon.immncweb.core.entity.Comment;
import com.moon.immncweb.core.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/09
 * @Desc
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment where aid = #{aid} and show_state = 1 ORDER BY `time` DESC limit 5,15")
    List<Comment> selectDetailAllComment(@Param("aid") String aid);
}
