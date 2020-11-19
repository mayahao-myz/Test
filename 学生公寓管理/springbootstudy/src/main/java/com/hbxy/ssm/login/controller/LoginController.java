package com.hbxy.ssm.login.controller;

import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.AppService;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.RoleRight;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.model.RoleUser;
import com.hbxy.ssm.admin.right.model.RoleUserExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.admin.right.service.RoleUserService;
import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.model.UserLoginExample;
import com.hbxy.ssm.admin.user.service.UserLoginService;
import com.hbxy.ssm.util.LoginValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class LoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private RoleUserService roleUserService;
    @Autowired
    private RoleRightService roleRightService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private AppService appService;

    //进入登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tologin(){
        return  "/login";
    }

    //处理登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserLogin user, Model model, HttpServletRequest request) {
        // 获取用户名和密码
        String userLoginId = user.getUserLoginId();
        String password = user.getCurrentPassword();
        // 从数据库中获取用户名和密码后进行判断
        if (userLoginId != null && password != null) {
            UserLoginExample example =new UserLoginExample();
            UserLoginExample.Criteria criteria = example.createCriteria();
            criteria.andUserLoginIdEqualTo(userLoginId);
            List<UserLogin> list = userLoginService.selectByExample(example);
            if (list.size() > 0) {
                UserLogin userLogin =list.get(0);
                if (LoginValidate.validate(password, userLogin.getCurrentPassword())) {
                    // 将用户对象添加到Session
                    request.getSession().setAttribute("USER_SESSION", userLogin);

                    // 前面已经定义了：用户---角色---模块  关系
                    // 登录时：判断当前用户能够访问哪些应用模块
                    // 得到用户访问列表，放进 session 里面
                    makeRightAccess(userLogin.getUserId(),model,request);

                    if ("1".equalsIgnoreCase(userLogin.getIsSystem()) || "2".equalsIgnoreCase(userLogin.getIsSystem())) {
                       //系统管理员
                        return "redirect:/admin/index";
                    } else {
                        //普通用户使用的页面
                        return "redirect:/app/index";
                    }
                }
            }
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");

        return "/login";
    }

    //退出系统
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        // 清除Session
        session.invalidate();
        // 重定向到登录页面的跳转方法
        return "redirect:login";
    }


    //构造权限访问列表
    private void makeRightAccess(String userId,Model model, HttpServletRequest request){
        //子系统
        List<App> appList = new ArrayList<>();
        //功能模块
        List<Module> moduleList = new ArrayList<>();

        //1 得到用户的角色列表
        RoleUserExample roleUserExample = new RoleUserExample();
        RoleUserExample.Criteria criteria = roleUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<RoleUser> roleUserList = roleUserService.selectByExample(roleUserExample);
        List<String> roleIds = new ArrayList<>();
        for (RoleUser roleUser:roleUserList){
            roleIds.add(roleUser.getRoleId());
        }

        //2 得到角色能够访问的模块列表
        //只有判断有角色的用户
        List<String> moduleIds = new ArrayList<>();
        if(roleIds.size() > 0){
            RoleRightExample roleRightExample = new RoleRightExample();
            RoleRightExample.Criteria criteria2 = roleRightExample.createCriteria();
            criteria2.andRoleIdIn(roleIds);
            List<RoleRight> roleRightList = roleRightService.selectByExample(roleRightExample);
            for (RoleRight roleRight : roleRightList){
                moduleIds.add(roleRight.getResourceId());
            }
        }

        //3 得到模块的信息
        if(moduleIds.size() > 0){
            //3.1 查询模块
            ModuleExample moduleExample = new ModuleExample();
            ModuleExample.Criteria criteria3 = moduleExample.createCriteria();
            criteria3.andModuleIdIn(moduleIds);
            criteria3.andCurrentStatusEqualTo("0");//正常
            moduleList = moduleService.selectByExample(moduleExample);
         //HashSet<>同时也被称为集合，该容器中只能存储不重复的对象。
            Set<String> set = new HashSet<>();
            for(Module module:moduleList){
                set.add(module.getAppId());
            }

            //3.2 查找子系统（模块分组）
            AppExample appExample = new AppExample();
            AppExample.Criteria criteria4 = appExample.createCriteria();
            criteria4.andCurrentStatusEqualTo("0");
            criteria4.andAppIdIn(new ArrayList<>(set));

            appList = appService.selectByExample(appExample);

        }

        //4 把当前用户能够访问的子系统，模块 放进session，
        // 然后在app_index.jsp构造出菜单
        request.getSession().setAttribute("right_app",appList);
        request.getSession().setAttribute("right_module",moduleList);

    }

}
