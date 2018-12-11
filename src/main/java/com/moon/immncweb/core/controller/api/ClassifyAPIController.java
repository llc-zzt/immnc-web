package com.moon.immncweb.core.controller.api;

import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.core.entity.Classify;
import com.moon.immncweb.core.service.ClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/27
 * @Desc
 */
@RestController
@RequestMapping("/moon/classify")
@Api(tags = {"新闻分类总和"})
public class ClassifyAPIController {


    @Autowired
    private ClassifyService classifyService;

    @PostMapping(value = {"/select"})
    @ApiOperation(value = "查询所有的分类")
    public ResponseVO<List<Classify>> selectList(){
        return ResponseVO.e(ResponseCode.SUCCESS,classifyService.findAllToDB());
    }
}
