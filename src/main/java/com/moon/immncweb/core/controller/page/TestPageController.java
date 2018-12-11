package com.moon.immncweb.core.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author zhaoxiang
 * @Date 2018/11/28
 * @Desc
 */
@Controller
@RequestMapping("/")
public class TestPageController {

    @GetMapping("test")
    public ModelAndView test(){
        return new ModelAndView("page/nav");
    }
}
