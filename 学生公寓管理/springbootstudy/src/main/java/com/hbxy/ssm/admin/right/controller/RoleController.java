package com.hbxy.ssm.admin.right.controller;

import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.AppService;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.*;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.admin.right.service.RoleService;
import com.hbxy.ssm.admin.right.service.RoleUserService;
import com.hbxy.ssm.util.IdUtil;
import com.hbxy.ssm.util.UserLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/admin")

//角色管理
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private AppService appService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleRightService roleRightService;
    @Autowired
    private RoleUserService roleUserService;

    @RequestMapping("/rolelist")
    public String rolelist(){
        return "/admin/role_list";
    }

    //查询
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public @ResponseBody
    Object roleGet(Model model, HttpServletRequest request){
        List<Role> list = new ArrayList<>();

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andCurrentStatusEqualTo("0");
        roleExample.setOrderByClause(" order_index");//设置排序字段

        list = roleService.selectByExample(roleExample);

        return list;
    }

    //添加
    @RequestMapping(value = "/role",method = RequestMethod.POST,produces ="application/json" )
    public @ResponseBody
    Object roleAdd(@RequestBody Role role,
                   Model model, HttpServletRequest request){
        String id = IdUtil.nextId().toString();
        role.setRoleId(id);
        role.setCurrentStatus("0");//0-正常状态;1-删除状态;
        role.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        //与用户登录的账号关联？
        role.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        role.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        role.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        roleService.insertSelective(role);

        return role;
    }

    //修改信息
    @RequestMapping(value = "/role",method = RequestMethod.PUT,produces ="application/json" )
    public @ResponseBody
    Object roleEdit(@RequestBody Role role,
                    Model model, HttpServletRequest request){
        role.setCurrentStatus("0");//0-正常状态;1-删除状态;
        role.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        role.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        roleService.updateByPrimaryKeySelective(role);

        return role;
    }

    //删除
    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public @ResponseBody
    Object roleEdit(@PathVariable String id,
                    Model model, HttpServletRequest request){
        roleService.deleteByPrimaryKey(id);

        //删除角色相关联的模块(role_right表里的数据) ？
        RoleRightExample roleRightExample = new RoleRightExample();
        RoleRightExample.Criteria criteria1 = roleRightExample.createCriteria();
        criteria1.andRoleIdEqualTo(id);
        roleRightService.deleteByExample(roleRightExample);


        //删除角色关联的用户(role_user表里的数据) 授权管理
        RoleUserExample roleUserExample = new RoleUserExample();
        RoleUserExample.Criteria criteria2 = roleUserExample.createCriteria();
        criteria2.andRoleIdEqualTo(id);
        roleUserService.deleteByExample(roleUserExample);



        return "200";
    }

    //获得应用模块，作为权限资源
    @RequestMapping(value = "/moduleright", method = RequestMethod.GET)
    public @ResponseBody
    Object modules(Model model, HttpServletRequest request){
        Map rights = new HashMap<>();

        List<RightNode> list = new ArrayList<>();

        AppExample appExample = new AppExample();
        AppExample.Criteria criteria = appExample.createCriteria();
        criteria.andCurrentStatusEqualTo("0");
        appExample.setOrderByClause(" order_index");
        List<App> applist = appService.selectByExample(appExample);

        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria2 = moduleExample.createCriteria();
        criteria2.andCurrentStatusEqualTo("0");
        moduleExample.setOrderByClause(" order_index");
        List<Module> modulelist = moduleService.selectByExample(moduleExample);

        for(App app : applist){
            RightNode appNode = new RightNode();
            appNode.setId(app.getAppId());
            appNode.setLabel(app.getAppName());
            for(Module module: modulelist){
                if(app.getAppId().equalsIgnoreCase(module.getAppId())){
                    RightNode mnoduleNode = new RightNode();
                    mnoduleNode.setId(module.getModuleId());
                    mnoduleNode.setLabel(module.getModuleName());
                    mnoduleNode.setIsModule("1");
                    //当前appNode添加子节点
                    appNode.addChildren(mnoduleNode);
                }
            }
            //把构造好的appNode添加到list
            list.add(appNode);
        }


        return list;
    }
    //分配权限
    @Transactional
    @RequestMapping(value = "/roleright/{roleId}",method = RequestMethod.POST, produces ="application/json")
    public @ResponseBody
    Object roleRight(@PathVariable("roleId") String roleId, @RequestBody List<RightNode> rightNodes,
                     Model model, HttpServletRequest request){

        if(roleId != null && rightNodes != null){
            //先删除原先有的权限
            RoleRightExample example = new RoleRightExample();
            RoleRightExample.Criteria criteria = example.createCriteria();
            criteria.andRoleIdEqualTo(roleId);
            roleRightService.deleteByExample(example);

            //再添加本次分配给的权限
            for(RightNode rightNode : rightNodes){
                //只有模块一级才保存
                if("1".equalsIgnoreCase(rightNode.getIsModule())){
                    RoleRight roleRight = new RoleRight();
                    roleRight.setRoleRightId(IdUtil.nextId().toString());
                    roleRight.setRoleId(roleId);
                    roleRight.setResourceId(rightNode.getId());

                    roleRightService.insertSelective(roleRight);
                }
            }
        }
        return "200";
    }

    @RequestMapping(value = "/roleright/{roleId}",method = RequestMethod.GET)
    public @ResponseBody
    Object roleRightList(@PathVariable("roleId") String roleId,
                         Model model, HttpServletRequest request) {
        RoleRightExample example = new RoleRightExample();
        RoleRightExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<RoleRight> list = roleRightService.selectByExample(example);

        List<String> idList = new ArrayList<>();

        for (RoleRight roleRight : list){
            idList.add(roleRight.getResourceId());
        }
        return idList;
    }
}
