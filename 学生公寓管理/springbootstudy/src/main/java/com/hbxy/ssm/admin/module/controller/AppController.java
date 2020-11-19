package com.hbxy.ssm.admin.module.controller;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.AppService;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.util.IdUtil;
import com.hbxy.ssm.util.UserLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问，让你能访问不是一个域（域名，协议，端口）的文件。
@Controller   //处理http请求
@RequestMapping("/admin") //@RequestMapping后，返回值通常解析为跳转路径，
public class AppController {

//@Autowired注解的作用是解决对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    //扫描当前类中标注@Autowired的属性和方法；再查找父类中注@Autowired的属性和方法，依次遍历；
    @Autowired
    //子系统
    private AppService appService;
    @Autowired
    //子功能
    private ModuleService moduleService;
    //角色
    @Autowired
    private RoleRightService roleRightService;

    //进入模块
    @RequestMapping("/applist")
    //解析return的jsp，html页面，并跳转到相应页面
    public String appList(){
        return "/admin/app_list";
    }

    //查询
    //@RequestMapping将控制器类处理的所有请求都被映射到value属性所指示的路径下，通过访问这个地址路径来调用方法。method属性是用来确定调用方式的
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public @ResponseBody
    Object appGet(Model model, HttpServletRequest request){
//mybatis的逆向工程中会生成实例及实例对应的example，example用于添加条件，相当where后面的部分
        List<App> list = new ArrayList<>();
        AppExample appExample = new AppExample();
        AppExample.Criteria criteria = appExample.createCriteria();
        //正常使用
        criteria.andCurrentStatusEqualTo("0");
        //添加排列条件
        appExample.setOrderByClause(" order_index");
//按条件查询
        list = appService.selectByExample(appExample);
//返回list集合
        return list;
    }

    //添加
                                                                // 表示将生产json格式的数据，
    @RequestMapping(value = "/app",method = RequestMethod.POST, produces = "application/json")
    // @ResponseBody 返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。将java对象转为json格式的数据
    //@RequestBody   主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；
    public @ResponseBody
    Object appAdd(@RequestBody App app,
                  Model model, HttpServletRequest request){
        String id= IdUtil.nextId().toString();
        app.setAppId(id);
        app.setCurrentStatus("0");//0-正常状态;1-删除状态;
        app.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        app.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        app.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        app.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        appService.insert(app);

        return app;
    }

    //修改
    @RequestMapping(value = "/app",method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Object appEdit(@RequestBody App app,
                   Model model, HttpServletRequest request){
        app.setCurrentStatus("0");//0-正常状态;1-删除状态;
        app.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));//最近一次的更新时间
        app.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        appService.updateByPrimaryKeySelective(app);

        //更新模块表中关联的子系统名称
        Module module = new Module();
        module.setAppName(app.getAppName());//设置要修改的内容
        module.setCurrentStatus("0");
        module.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        module.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        //设置条件，添加AppId字段等于app.getAppId()条件
        criteria.andAppIdEqualTo(app.getAppId());
        //根据条件，有选择的更新内容
        moduleService.updateByExampleSelective(module,moduleExample);

        return app;
    }

    //删除
    @RequestMapping(value = "/app/{id}",method = RequestMethod.DELETE)//@RequestMapping 注解映射请求路径
    public @ResponseBody   //@ResponseBody的作用其实是将java对象转为json格式的数据
    Object appDelete(@PathVariable String id,
                     Model model, HttpServletRequest request){
        appService.deleteByPrimaryKey(id);

        //查询出关联的模块
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(id);

        List<Module> moduleList = moduleService.selectByExample(moduleExample);

        //删除模块表关联的模块
        //根据条件删除子表记录
        moduleService.deleteByExample(moduleExample);


        ////删除与角色相关联的模块(role_right表里的数据)
        if(moduleList.size() > 0){
            List<String> moduleIds = new ArrayList<>();
            for(Module module: moduleList){
                moduleIds.add(module.getModuleId());
            }
            RoleRightExample roleRightExample = new RoleRightExample();
            RoleRightExample.Criteria criteria2 = roleRightExample.createCriteria();
            criteria2.andResourceIdIn(moduleIds);
            roleRightService.deleteByExample(roleRightExample);
        }

        return "200";
    }

}
