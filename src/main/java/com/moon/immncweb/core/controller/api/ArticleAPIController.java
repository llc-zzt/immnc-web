package com.moon.immncweb.core.controller.api;

import com.baomidou.mybatisplus.plugins.Page;
import com.moon.immncweb.common.bean.ResponseCode;
import com.moon.immncweb.common.bean.ResponseVO;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.service.NewsRedisService;
import com.moon.immncweb.core.utils.CookieUtil;
import com.moon.immncweb.core.utils.HTMLSpirit;
import com.moon.immncweb.core.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

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

    @PostMapping("/searchNumber/update")
    @ApiOperation(value = "文章热搜更新")
    public ResponseVO<ResponseCode> updateTopNum(@RequestParam(value = "id") String id) {
        articleInfoService.updateTopNum(id);
        return ResponseVO.e(ResponseCode.SUCCESS);
    }

    @PostMapping("/index")
    @ApiOperation(value = "查询首页推荐文章")
    public ResponseVO<Page<NewsVO>> selectIndexNews(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                    HttpServletRequest request, HttpServletResponse response) {
        if (page > 1) {
            page = new Random().nextInt(1000);
        }

        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.selectHomeNewsByPage(new Page<>(page, size)));
    }

    @PostMapping("/classify")
    @ApiOperation(value = "查询分类推荐文章")
    public ResponseVO<Page<NewsVO>> selectIndexNews(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                    @RequestParam(value = "classify", required = true) Integer classify,
                                                    HttpServletRequest request, HttpServletResponse response) {
        page = new Random().nextInt(500);
        Page<NewsVO> newsVOPage = articleInfoService.selectClassifyNewsByPage(new Page<>(page, size), classify);
        return ResponseVO.e(ResponseCode.SUCCESS, newsVOPage);
    }

    @PostMapping("/detail/type")
    @ApiOperation(value = "查询详情相关推荐")
    public ResponseVO<Page<NewsVO>> selectDetailNewsByKey(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam(value = "type") Integer type,
                                                          HttpServletRequest request) {
        page = new Random().nextInt(500);
        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.selectNewsByDetailType(new Page<>(page, size), type));
    }

    @PostMapping("/like/title")
    @ApiOperation(value = "文章标题模糊搜索")
    public ResponseVO<Page<NewsVO>> listLikeSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                   @RequestParam(value = "title") String title) {

        String titleTemp = HTMLSpirit.replaceBlank(title);
        if ("".equals(titleTemp) && title == null) {
            return ResponseVO.e(-100, "请输入关键字");
        }
        return ResponseVO.e(ResponseCode.SUCCESS, articleInfoService.pageLikeSearch(new Page<>(page, size), title));


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
