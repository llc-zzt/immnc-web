package com.moon.immncweb.core.controller.page;

import com.baomidou.mybatisplus.plugins.Page;
import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.config.WebUrlConfig;
import com.moon.immncweb.core.entity.ArticleInfo;
import com.moon.immncweb.core.entity.SearchWords;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.service.SearchWordsService;
import com.moon.immncweb.core.utils.RandomUtil;
import com.moon.immncweb.core.utils.SEOUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Map;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc
 */
@Controller
@RequestMapping("/")
public class ArticleInfoPageController {

    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private SearchWordsService searchWordsService;
    @Autowired
    private WebUrlConfig config;

    @GetMapping("news/{classify}")
    public ModelAndView home(@PathVariable(value = "classify") Integer classify,
                             HttpServletRequest request, Map<String, Object> map) {
        map.put("topNews", new ArrayList<NewsVO>());
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("graphic",RandomUtil.createRandomList(articleInfoService.selectSideGraphic(),8));
        map.put("imgMap", RandomUtil.createRandomList(articleInfoService.selectSideImgMap(),6));
        map.put("videoList", RandomUtil.createRandomList(articleInfoService.selectSideVideo(),6));
        map.put("config", config);
        map.put("classifyId", classify);
        return new ModelAndView("page/type", map);
    }

    @GetMapping("/")
    public ModelAndView index(HttpServletRequest request, Map<String, Object> map) {
        map.put("topNews", articleInfoService.selectHomeTopToDb());
        map.put("banner", articleInfoService.selectBannerToDB());
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("graphic",RandomUtil.createRandomList(articleInfoService.selectSideGraphic(),8));
        map.put("imgMap", RandomUtil.createRandomList(articleInfoService.selectSideImgMap(),6));
        map.put("videoList", RandomUtil.createRandomList(articleInfoService.selectSideVideo(),6));
        map.put("config", config);
        map.put("classifyId", 0);
        return new ModelAndView("page/index", map);
    }

    @GetMapping("detail/{classify}/{newsId}")
    public ModelAndView detail(HttpServletRequest request, Map<String, Object> map,
                               @PathVariable(value = "classify") Integer classify,
                               @PathVariable(value = "newsId") String newsId) {
        NewsVO newsVO = articleInfoService.selectNewsDetail(newsId);
        map.put("title", newsVO.getTitle()+"_妙漫网创");
        map.put("keywords", newsVO.getTitle()+"_妙漫网创");
        map.put("description", SEOUtil.getDescription(newsVO.getContent()));
        map.put("newsVO", newsVO);
        map.put("topNews", articleInfoService.selectHomeTopToDb());
        map.put("banner", articleInfoService.selectBannerToDB());
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("graphic",RandomUtil.createRandomList(articleInfoService.selectSideGraphic(),8));
        map.put("imgMap", RandomUtil.createRandomList(articleInfoService.selectSideImgMap(),6));
        map.put("videoList", RandomUtil.createRandomList(articleInfoService.selectSideVideo(),6));
        map.put("authorInfo", articleInfoService.selectByAuthor(new Page<ArticleInfo>(1,10),newsVO.getUid()));
        map.put("config", config);
        map.put("classifyId", classify);
        if (newsVO.getTypeId() == 1) {
            return new ModelAndView("page/detail", map);
        }
        if (newsVO.getTypeId() == 2) {
            return new ModelAndView("page/imgsDetail", map);
        }
        if (newsVO.getTypeId() == 3) {
            return new ModelAndView("page/video", map);
        }
        return new ModelAndView("page/detail", map);
    }


    @GetMapping("search/page")
    public ModelAndView searchPage(HttpServletRequest request, Map<String, Object> map,
                               @RequestParam(value = "key") String key) {
        map.put("title", key);
        map.put("searchHotWords", searchWordsService.listSearchWordCountDesc());
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("graphic",RandomUtil.createRandomList(articleInfoService.selectSideGraphic(),8));
        map.put("imgMap", RandomUtil.createRandomList(articleInfoService.selectSideImgMap(),6));
        map.put("videoList", RandomUtil.createRandomList(articleInfoService.selectSideVideo(),6));
        map.put("config", config);
        map.put("classifyId", 0);
        return new ModelAndView("page/search-list", map);
    }
}
