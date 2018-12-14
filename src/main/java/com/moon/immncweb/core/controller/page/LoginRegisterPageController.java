package com.moon.immncweb.core.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author zhaoxiang
 * @Date 2018/12/13
 * @Desc
 */
@Controller
@RequestMapping("/")
public class LoginRegisterPageController {
    @GetMapping("login")
    public ModelAndView login(){
        return new ModelAndView("page/login");
    }
    @GetMapping("register")
    public ModelAndView register(){
        return new ModelAndView("page/register");
    }
}
