package com.moon.immncweb.core.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.service.NewsRedisService;
import com.moon.immncweb.core.utils.CookieUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc
 */
@RestController
@RequestMapping("/moon/article")
@Api(tags = {"新闻查询接口"})
public class ArticleAPIController {
    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private NewsRedisService redisService;

    @PostMapping("/banner")
    @ApiOperation(value = "查询轮播图")
    public ResponseVO<List<NewsVO>> selectBanner() {
        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.selectBannerToDB());
    }

    @PostMapping("/index")
    @ApiOperation(value = "查询首页推荐文章")
    public ResponseVO<Page<NewsVO>> selectIndexNews(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "7") Integer size,
                                                    HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, "index_page");
        Integer index_page = 1;
        if (cookie != null) {
            index_page = Integer.valueOf(CookieUtil.get(request, "index_page").getValue());
        }
        Integer setCookie = index_page + 1;
        CookieUtil.set(response, "index_page", String.valueOf(setCookie));
        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.selectHomeNewsByPage(new Page<>(index_page, size)));
    }

    @PostMapping("/classify")
    @ApiOperation(value = "查询分类推荐文章")
    public ResponseVO<Page<NewsVO>> selectIndexNews(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "7") Integer size,
                                                    @RequestParam(value = "classify", required = true) Integer classify,
                                                    HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, "classify_page_" + classify);
        Integer index_page = 1;
        if (cookie != null) {
            index_page = Integer.valueOf(CookieUtil.get(request, "classify_page_" + classify).getValue());
        }
        Page<NewsVO> newsVOPage = articleInfoService.selectClassifyNewsByPage(new Page<>(index_page, size), classify);
        Integer setCookie = index_page + 1;
        CookieUtil.set(response, "classify_page_" + classify, String.valueOf(setCookie));
        return ResponseVO.e(ResponseCode.SUCCESS, newsVOPage);
    }

    @PostMapping("/detail/type")
    @ApiOperation(value = "查询详情相关推荐")
    public ResponseVO<Page<NewsVO>> selectDetailNewsByKey(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "7") Integer size,
                                                          @RequestParam(value = "type") Integer type,
                                                          HttpServletRequest request) {
        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.selectNewsByDetailType(new Page<>(page, size), type));
    }

    @GetMapping("/redis/evict/news")
    @ApiOperation(value = "redis 文章清除")
    public ResponseVO newsEvict(@RequestParam Integer typeId) {
        return redisService.newsEvict(typeId);
    }

    @GetMapping("/redis/evict/banner")
    @ApiOperation(value = "redis banner清除")
    public ResponseVO bannersEvict() {
        return redisService.bannerEvict();
    }

    @GetMapping("/redis/evict/classify")
    @ApiOperation(value = "redis classify清除")
    public ResponseVO classifyEvict() {
        return redisService.classifyEvict();
    }


}
