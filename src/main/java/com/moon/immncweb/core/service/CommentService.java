package com.moon.immncweb.core.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.common.vo.CommentVO;
import com.moon.immncweb.core.entity.Comment;
import com.moon.immncweb.core.mapper.CommentMapper;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/12/10
 * @Desc
 */
public interface CommentService  {
    /**
     * 查询文章详情评论
     * @param page
     * @param aid
     * @return
     */
    Page<CommentVO> selectDetailFirstComment(Page<Comment> page, String aid);

    /**
     * 查询剩下的10全部评论
     * @param aid
     * @return
     */
    List<CommentVO> selectDetailAllComment(String aid);
}
