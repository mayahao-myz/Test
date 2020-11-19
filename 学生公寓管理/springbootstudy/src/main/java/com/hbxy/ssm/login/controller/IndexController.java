package com.hbxy.ssm.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    //系统默认到前端应用首页
    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
        return "/login";
    }

    //管理控制台
    @RequestMapping("/admin/index")
    public String adminIndex(){

        return "/admin/admin_index";
    }

    //管理控制台首页
    @RequestMapping("/admin/home")
    public String adminHome(){

        return "/admin/admin_home";
    }

    //普通用户应用前端
    @RequestMapping("/app/index")
    public String appIndex(){

        return "/app/app_index";
    }

    //应用前端内容首页
    @RequestMapping("/app/home")
    public String appHome(){

        return "/app/app_home";
    }
}
