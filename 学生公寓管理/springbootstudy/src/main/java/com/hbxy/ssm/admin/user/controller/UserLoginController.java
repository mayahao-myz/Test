package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.right.model.RoleUserExample;
import com.hbxy.ssm.admin.right.service.RoleUserService;
import com.hbxy.ssm.admin.user.model.Person;
import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.model.UserLoginExample;
import com.hbxy.ssm.admin.user.service.PersonService;
import com.hbxy.ssm.admin.user.service.UserLoginService;
import com.hbxy.ssm.util.EncryptUtil;
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
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/admin")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private PersonService personService;
    @Autowired
    private RoleUserService roleUserService;

    @RequestMapping("/userlist")
    public String lists(Model model, HttpServletRequest request){
        return "/admin/user_list";
    }

    //查询用户
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody
    Object users(Model model, HttpServletRequest request) {

        UserLoginExample example=new UserLoginExample();
        UserLoginExample.Criteria criteria=example.createCriteria();
        //0-正常状态;1-删除状态;2-禁用状态;4-已创建账号,但未开通
        criteria.andCurrentStatusNotEqualTo("1");//只查询标记为未删除的的用户
        //mysql字符编码为utf8mb4 中文拼音排序
        example.setOrderByClause(" is_system desc, convert(user_name using gbk) collate gbk_chinese_ci");

        List<UserLogin> users= new ArrayList<>();
        users=userLoginService.selectByExample(example);

        return users;
    }

    // @Transactional:spring数据库事务管理
    // 当有两个及以上的数据库表的添加/修改/删除操作时,要加上
    //注册用户
    @Transactional
    @RequestMapping(value = "/user" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    UserLogin userRegister(@RequestBody UserLogin userLogin,
                           Model model, HttpServletRequest request){
        String userId= IdUtil.nextId().toString();
        userLogin.setUserId(userId);
        userLogin.setCurrentPassword(EncryptUtil.encryptSHA256(userLogin.getCurrentPassword()));
        userLogin.setUserName(userLogin.getUserName());
        userLogin.setUserType("0");//0-个人；1-企业（组织）
        userLogin.setCurrentStatus("0");//0-正常状态;1-删除状态;2-禁用状态;4-已创建账号,但未开通
        userLogin.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        userLogin.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        Person person =new Person();
        person.setPersonId(userId);
        person.setUserId(userId);
        person.setFullName(userLogin.getUserName());
        person.setLastName(userLogin.getLastName());
        person.setFirstName(userLogin.getFirstName());
        person.setCurrentStatus("0");
        person.setGender("2");//未知性别
        person.setIsSystem(userLogin.getIsSystem());
        person.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        personService.insertSelective(person);

        userLoginService.insert(userLogin) ;

        return userLogin;
    }

    //修改用户信息
    @Transactional
    @RequestMapping(value = "/user" , method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    UserLogin userEdit(@RequestBody UserLogin userLogin,
                       Model model, HttpServletRequest request){
       if(userLogin.getUserName() != null || !"".equalsIgnoreCase(userLogin.getUserName()))
                {
           userLogin.setUserName(userLogin.getUserName());
       }

        userLogin.setCurrentStatus("0");

        userLogin.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        Person person =new Person();
        person.setPersonId(userLogin.getUserId());
        person.setUserId(userLogin.getUserId());
        person.setFullName(userLogin.getUserName());
        person.setLastName(userLogin.getLastName());
        person.setFirstName(userLogin.getFirstName());
        person.setCurrentStatus("0");
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));


        userLoginService.updateByPrimaryKeySelective(userLogin) ;
        personService.updateByPrimaryKeySelective(person);

        return userLogin;
    }

    //重置用户密码
    @Transactional
    @RequestMapping(value = "/resetpwd" , method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Object resetPwd(@RequestBody UserLogin userLogin,
                    Model model, HttpServletRequest request){
        if(userLogin.getCurrentPassword() != null || !"".equalsIgnoreCase(userLogin.getCurrentPassword())){
            userLogin.setCurrentPassword(EncryptUtil.encryptSHA256(userLogin.getCurrentPassword()));
        }
        userLogin.setCurrentStatus("0");

        userLogin.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        userLoginService.updateByPrimaryKeySelective(userLogin) ;

        return "200";
    }
    //删除用户
    @Transactional
    @RequestMapping(value = "/user/{userId}")
    public @ResponseBody
    Object userDel(@PathVariable("userId") String userId,
                   Model model, HttpServletRequest request){
        //1 假删除
        UserLogin userLogin = new UserLogin();
        userLogin.setUserId(userId);
        userLogin.setCurrentStatus("1");//设置为删除标记
        userLogin.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        Person person =new Person();
        person.setPersonId(userLogin.getUserId());
        person.setCurrentStatus("1");
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        /*userLoginService.updateByPrimaryKeySelective(userLogin);
        personService.updateByPrimaryKeySelective(person);*/


        //2 真删除
      userLoginService.deleteByPrimaryKey(userLogin.getUserId());
      personService.deleteByPrimaryKey(userLogin.getUserId());

        //删除组织关系

        //删除用户关联的角色(role_user表里的数据)
        RoleUserExample roleUserExample = new RoleUserExample();
        RoleUserExample.Criteria criteria2 = roleUserExample.createCriteria();
        criteria2.andUserIdEqualTo(userId);
        roleUserService.deleteByExample(roleUserExample);

        return "200";
    }
}
