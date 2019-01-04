package com.moon.immncweb.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.moon.immncweb.common.vo.CommentVO;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.entity.Comment;
import com.moon.immncweb.core.entity.UserInfo;
import com.moon.immncweb.core.mapper.CommentMapper;
import com.moon.immncweb.core.service.CommentService;
import com.moon.immncweb.core.service.UserInfoService;
import com.moon.immncweb.core.utils.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhaoxiang
 * @Date 2018/12/10
 * @Desc
 */
@Service
@Transactional
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public Page<CommentVO> selectDetailFirstComment(Page<Comment> page, String aid) {
        Page<CommentVO> commentPage = new Page<>(1, 5);

        EntityWrapper<Comment> wrapper = new EntityWrapper<>();
        wrapper.eq("aid", aid).eq("show_state", 1).orderBy("time", false);
        page = this.selectPage(page, wrapper);
        BeanUtils.copyProperties(page, commentPage);
        if (!page.getRecords().isEmpty()) {
//       更新表
            commentPage.setRecords(page.getRecords().stream().map(e -> {
                return updateUserInfo(e);
            }).collect(Collectors.toList()));
        }
        return commentPage;
    }

    @Override
    public List<CommentVO> selectDetailAllComment(String aid) {
        List<Comment> commentList = this.baseMapper.selectDetailAllComment(aid);
        List<CommentVO> commentVOList = new ArrayList<>();
        if (!commentList.isEmpty()) {
            commentVOList =  commentList.stream().map(e -> {
                return updateUserInfo(e);
            }).collect(Collectors.toList());
        }
        return commentVOList;
    }


    private CommentVO updateUserInfo(Comment comment) {
        CommentVO commentVO = new CommentVO();

        if (comment.getAvatar() == null) {
            UserInfo userInfo = userInfoService.selectById(comment.getUid());
            comment.setAvatar(userInfo.getAvatar());
            comment.setNickName(userInfo.getNikeName());
            this.updateById(comment);
        }
        commentVO.setTime(TimeUtil.getDateFormat(comment.getTime()));
        BeanUtils.copyProperties(comment, commentVO);
        return commentVO;
    }
}
