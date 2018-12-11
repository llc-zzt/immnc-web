package com.moon.immncweb.core.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.common.vo.CommentVO;
import com.moon.immncweb.core.entity.Comment;
import com.moon.immncweb.core.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/12/10
 * @Desc
 */
@RestController
@RequestMapping("/moon/comment")
@Api(tags = {"评论查询接口"})
public class CommentAPIController {
    @Autowired
    private CommentService service;

    @PostMapping("/first")
    @ApiOperation(value = "第一次的评论查询")
    public ResponseVO<Page<CommentVO>> selectDetailFirstComment(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                @RequestParam(value = "size", defaultValue = "5") Integer size,
                                                                @RequestParam(value = "aid") String aid) {
        return ResponseVO.e(ResponseCode.SUCCESS, service.selectDetailFirstComment(new Page<Comment>(page, size), aid));
    }
    @PostMapping("/all")
    @ApiOperation(value = "剩下的评论查询")
    public ResponseVO<List<CommentVO>> selectDetailFirstComment(@RequestParam(value = "aid") String aid) {
        return ResponseVO.e(ResponseCode.SUCCESS, service.selectDetailAllComment(aid));
    }
}
