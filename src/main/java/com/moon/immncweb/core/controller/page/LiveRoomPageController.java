package com.moon.immncweb.core.controller.page;

import com.moon.immncweb.common.vo.NewsVO;
import com.moon.immncweb.core.config.WebUrlConfig;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Author zhaoxiang
 * @Date 2018/12/19
 * @Desc
 */
@Controller
@RequestMapping("/live")
public class LiveRoomPageController {
    @Autowired
    private ArticleInfoService articleInfoService;
    @Autowired
    private WebUrlConfig config;

    @GetMapping("/{room}")
    public ModelAndView downloadAPP(@PathVariable(value = "room")String room,
                                    Map<String,Object> map){
        map.put("topNews", new ArrayList<NewsVO>());
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("config", config);
        map.put("classifyId", 0);
        return new ModelAndView("page/video-live",map);
    }
}
