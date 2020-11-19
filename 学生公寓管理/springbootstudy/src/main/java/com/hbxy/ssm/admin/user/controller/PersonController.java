package com.hbxy.ssm.admin.user.controller;

import com.hbxy.ssm.admin.user.model.Person;
import com.hbxy.ssm.admin.user.model.PersonExample;
import com.hbxy.ssm.admin.user.model.UserLogin;
import com.hbxy.ssm.admin.user.service.PersonService;
import com.hbxy.ssm.admin.user.service.UserLoginService;
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

/**
 * 业务管理员进行员工管理
 * 添加员工时,同时会给该员工注册一个 系统登录用的账号
 */
@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/app")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/emplist")
    public String lists(Model model, HttpServletRequest request){
        return "/app/emp_list";
    }

    //查询员工
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public @ResponseBody
    Object emps(Person person,
                Model model, HttpServletRequest request) {

        PersonExample example=new PersonExample();
        PersonExample.Criteria criteria=example.createCriteria();
        criteria.andCurrentStatusEqualTo("0");//只查询状态正常的用户
        criteria.andIsSystemEqualTo("0");

        //mysql字符编码为utf8mb4 中文拼音排序
        example.setOrderByClause(" convert(full_name using gbk) collate gbk_chinese_ci");

        List<Person> emps= new ArrayList<>();
        emps=personService.selectByExample(example);

        return emps;
    }

    // @Transactional:spring数据库事务管理
    // 当有两个及以上的数据库表的添加/修改/删除操作时,要加上
    // 添加员工
    @Transactional
    @RequestMapping(value = "/emp" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Person personAdd(@RequestBody Person person,
                     Model model, HttpServletRequest request){
        //员工信息
        String personId= IdUtil.nextId().toString();
        person.setPersonId(personId);
        person.setUserId(personId);
        person.setFullName(person.getLastName()+person.getFirstName());
        //其他信息直接使用页面传过来的
        person.setCurrentStatus("0");//0-正常状态;1-删除状态;2-禁用状态;4-已创建账号,但未开通
        person.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        //系统账号
        UserLogin userLogin =new UserLogin();
        userLogin.setUserId(personId);

        userLogin.setUserName(person.getLastName()+person.getFirstName());
        userLogin.setLastName(person.getLastName());
        userLogin.setFirstName(person.getFirstName());

        userLogin.setIsSystem("0");//普通用户
        userLogin.setUserType("0");//0-个人；1-企业（组织）
        userLogin.setCurrentStatus("4");//0-正常状态;1-删除状态;2-禁用状态;4-已创建账号,但未开通
        userLogin.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        userLogin.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        userLogin.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        userLoginService.insert(userLogin) ;

        personService.insertSelective(person);

        return person;
    }

    // 修改员工信息
    @Transactional
    @RequestMapping(value = "/emp" , method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Person personEdit(@RequestBody Person person,
                      Model model, HttpServletRequest request){

        person.setPersonId(person.getPersonId());
        person.setFullName(person.getLastName()+person.getFirstName());
        //其他信息直接使用页面传过来的
        person.setCurrentStatus("0");
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));

        personService.updateByPrimaryKeySelective(person);

        return person;
    }

    //删除员工信息
    @Transactional
    @RequestMapping(value = "/emp/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody
    Object personDelete(@PathVariable("id") String id,
                        Model model, HttpServletRequest request){
        //1 假删除
        Person person =new Person();
        person.setPersonId(id);
        person.setCurrentStatus("1");
        person.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        person.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        personService.updateByPrimaryKeySelective(person);

//        //2 真删除
//        personService.deleteByPrimaryKey(id);

        return "200";
    }

}
