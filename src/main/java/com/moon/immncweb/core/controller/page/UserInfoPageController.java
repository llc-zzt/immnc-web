package com.moon.immncweb.core.controller.page;

import com.moon.immncweb.core.config.WebUrlConfig;
import com.moon.immncweb.core.service.ArticleInfoService;
import com.moon.immncweb.core.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author zhaoxiang
 * @Date 2018/12/25
 * @Desc
 */
@Controller
@RequestMapping("/")
public class UserInfoPageController {
    @Autowired
    private WebUrlConfig config;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private ArticleInfoService articleInfoService;
    @GetMapping("user/update/{id}")
    public ModelAndView updateUser(@PathVariable(value = "id")String id,
                                   Map<String,Object> map){
        map.put("user",userInfoService.getUserInfoById(id));
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("config", config);
        map.put("classifyId", 0);
        return new ModelAndView("page/personnel-update");
    }
    @GetMapping("user/{id}")
    public ModelAndView user(@PathVariable(value = "id")String id,
                                   Map<String,Object> map){
        map.put("user",userInfoService.getUserInfoById(id));
        map.put("searchTopList", articleInfoService.selectHotSearch());
        map.put("config", config);
        map.put("classifyId", 0);
        return new ModelAndView("page/personnel");
    }
}
