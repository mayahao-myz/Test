package com.hbxy.ssm.admin.right.controller;

import com.hbxy.ssm.admin.right.model.Role;
import com.hbxy.ssm.admin.right.model.RoleUser;
import com.hbxy.ssm.admin.right.model.RoleUserExample;
import com.hbxy.ssm.admin.right.service.RoleUserService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/admin")

//授权管理
public class RightController {
    @Autowired
    private RoleUserService roleUserService;

    @RequestMapping(value = "/roleuser", method = RequestMethod.GET)
    public String roleuser() {
        return "/admin/role_user";
    }

    @RequestMapping(value = "/roleuser/{userId}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object roleuserAdd(@PathVariable("userId") String userId,
                       @RequestBody List<Role> roles) {

        if (userId != null && roles != null) {
            //先删除原先授予的角色
            RoleUserExample example = new RoleUserExample();
            RoleUserExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            roleUserService.deleteByExample(example);

            //再添加本次授予的角色
            for (Role role : roles) {
                //只有模块一级才保存
                RoleUser roleUser = new RoleUser();
                roleUser.setRoleUserId(IdUtil.nextId().toString());
                roleUser.setUserId(userId);
                roleUser.setRoleId(role.getRoleId());
                roleUser.setRoleName(role.getRoleName());

                roleUserService.insertSelective(roleUser);
            }
        }

        return "200";
    }

    @RequestMapping(value = "/roleuser/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    Object roleuserList(@PathVariable("userId") String userId) {
        List<String> roleIds = new ArrayList<>();

        RoleUserExample example = new RoleUserExample();
        RoleUserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<RoleUser> roleUserList = roleUserService.selectByExample(example);
        if(roleUserList.size() > 0){
            for (RoleUser roleUser:roleUserList){
                roleIds.add(roleUser.getRoleId());
            }
        }

        return roleIds;
    }
}
