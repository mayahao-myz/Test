package com.hbxy.ssm.admin.module.controller;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
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

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/admin")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleRightService roleRightService;

    //进入模块
    @RequestMapping("/modulelist")
    public String moduleList(){
        return "/admin/app_module_list";
    }

    //查询
    @RequestMapping(value = "/module/{appId}", method = RequestMethod.GET)
    public @ResponseBody
    Object moduleGet(@PathVariable String appId, Model model, HttpServletRequest request){
        List<Module> list = new ArrayList<>();

        //查询子系统下的模块
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(appId);
        criteria.andCurrentStatusEqualTo("0");
        moduleExample.setOrderByClause(" order_index");

        list = moduleService.selectByExample(moduleExample);

        return list;
    }

    //添加
    @RequestMapping(value = "/module",method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object moduleAdd(@RequestBody Module module,
                     Model model, HttpServletRequest request){
        String id= IdUtil.nextId().toString();
        module.setModuleId(id);
        module.setCurrentStatus("0");//0-正常状态;1-删除状态;
        module.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        module.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        module.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        module.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        moduleService.insert(module);

        return module;
    }

    //修改
    @RequestMapping(value = "/module",method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Object moduleEdit(@RequestBody Module module,
                      Model model, HttpServletRequest request){
        module.setCurrentStatus("0");//0-正常状态;1-删除状态;
        module.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        module.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        moduleService.updateByPrimaryKeySelective(module);

        return module;
    }

    //删除
    @RequestMapping(value = "/module/{id}",method = RequestMethod.DELETE)
    public @ResponseBody
    Object moduleDelete(@PathVariable String id,
                        Model model, HttpServletRequest request){
        moduleService.deleteByPrimaryKey(id);

        //删除与角色相关联的模块(role_right表里的数据)
        RoleRightExample roleRightExample = new RoleRightExample();
        RoleRightExample.Criteria criteria2 = roleRightExample.createCriteria();
        criteria2.andResourceIdEqualTo(id);
        roleRightService.deleteByExample(roleRightExample);

        return "200";
    }

}
