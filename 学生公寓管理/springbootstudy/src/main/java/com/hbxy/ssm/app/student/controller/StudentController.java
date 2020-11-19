package com.hbxy.ssm.app.student.controller;

import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.app.student.model.Student;
import com.hbxy.ssm.app.student.model.StudentExample;
import com.hbxy.ssm.app.student.service.StudentService;
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
@RequestMapping("/app")// @RequestMapping后，返回值通常解析为跳转路径，
public class StudentController {
    @Autowired
    private StudentService StudentService;
//子模块，
    @Autowired
    private ModuleService moduleService;
    //角色
    @Autowired
    private RoleRightService roleRightService;

    //进入模块
    @RequestMapping("/studentlist")// @RequestMapping后，返回值通常解析为跳转路径，
    //返回该页面（jsp）
    public String StudentList(){

        return "/app/student_list";
    }

    //@ResponseBody是作用在方法上的，@ResponseBody 表示该方法的返回结果json直接写入 HTTP response body 中，
    //通常用来返回JSON数据或者是XML数据。

    //查询学生信息
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public @ResponseBody
    Object StudentGet(Model model, HttpServletRequest request){
        //controller与jsp响应
        List<Student> list = new ArrayList<>();
        StudentExample StudentExample = new StudentExample();
//        StudentExample.Criteria criteria = StudentExample.createCriteria();
//        criteria.andCurrentStatusEqualTo("0");
//        StudentExample.setOrderByClause("order_index");

        //controller与service
        list = StudentService.selectByExample(StudentExample);

        return list;
    }

    //添加
    //@RequestBody Equipment通过@RequestBody接收json格式数据
    @RequestMapping(value = "/student",method = RequestMethod.POST, produces = "application/json")//表示将生产json格式的数据，
    public @ResponseBody
    Object StudentAdd(@RequestBody Student Student,
                        Model model, HttpServletRequest request){
//        String id= IdUtil.nextId().toString();
//        Student.setStuNo(Integer.valueOf(IdUtil.nextId()));
//        Student.setCurrentStatus("0");//0-正常状态;1-删除状态;
//        Student.setCreatedTime(new Timestamp(System.currentTimeMillis()));
//        Student.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
//        Student.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
//        Student.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        //才会将数据库的信息显示在页面上
        Student.setStuNo(Student.getStuNo());
        Student.setStuMajor(Student.getStuMajor());
        Student.setStuName(Student.getStuName());
        Student.setStuSex(Student.getStuSex());
        Student.setDormNo(Student.getDormNo());
        Student.setStuPhone(Student.getStuPhone());
        StudentService.insert(Student);
        return Student;//json格式数据
    }

    //修改
    @RequestMapping(value = "/student",method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Object StudentEdit(@RequestBody Student Student,
                         Model model, HttpServletRequest request){
//        Student.setCurrentStatus("0");//0-正常状态;1-删除状态;
//        Student.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
//        StudentsetLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        StudentService.updateByPrimaryKeySelective(Student);

        //更新模块表中关联的子系统名称
        Module module = new Module();
        module.setAppName(Student.getStuName());//设置要修改的内容
//        module.setCurrentStatus("0");
//        module.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
//        module.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(String.valueOf(Student.getStuNo()));//设置条件
        //根据条件，有选择的更新内容
        moduleService.updateByExampleSelective(module,moduleExample);

        return Student;
    }

    //删除
    @RequestMapping(value = "/student/{id}",method = RequestMethod.DELETE)
    public @ResponseBody
    Object EquipmentDelete(@PathVariable String id,
                           Model model, HttpServletRequest request){
        StudentService.deleteByPrimaryKey(id);

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

            List<String> m=new ArrayList<>();
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
