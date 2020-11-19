package com.hbxy.ssm.app.studentquery.controller;

import com.hbxy.ssm.app.student.model.Student;
import com.hbxy.ssm.app.student.model.StudentExample;
//import com.hbxy.ssm.app.student.service.StudentQueryService;
//import com.hbxy.ssm.app.studentquery.model.StudentQuery;
//import com.hbxy.ssm.app.studentquery.service.StudentQueryService;
import com.hbxy.ssm.app.studentquery.model.StudentQuery;
import com.hbxy.ssm.app.studentquery.model.StudentQueryExample;
import com.hbxy.ssm.app.studentquery.service.StudentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//查询用的不同的类，同一张数据表，数据回填到不同的请求页面
//js允许跨域访问
// @RequestMapping后，返回值通常解析为跳转路径，
@CrossOrigin
@Controller
@RequestMapping("/app")
public class StudentQueryController {
    @Autowired
    private StudentQueryService studentQueryService;
    //请求的初始页面
    @RequestMapping("/studentquerylist")
    //返回请求的页面
    public String StudentQueryList(Model model,HttpServletRequest request){

        return "/app/studentquery_list";
    }

    //条件查询
    //学生查询信息
    @RequestMapping(value = "/studentquery/{stuNo}",method= RequestMethod.GET,produces = "application/json")
    public @ResponseBody Object StudentQuery(@PathVariable("stuNo") Integer stuNo,Model model, HttpServletRequest request)
    {
        //controller与jsp响应
        //测试查询按钮是否触发
        System.out.println("一定要成功！");
        //逻辑层去与数据库交互
//        StudentQuery studentQuery=StudentQueryService.selectByPrimaryKey(stuNo);
        //返回数据
//        return  studentQuery;

        //criteria 条件查询的方法
        // oredCriteria
        //Example内有一个成员叫oredCriteria,是Criteria的集合,就想其名字所预示的一样，这个集合中的Criteria是由OR连接的，是逻辑或关系。oredCriteria就是ORed Criteria。
        StudentQueryExample example=new StudentQueryExample();
        StudentQueryExample.Criteria criteria=example.createCriteria();
        criteria.andStuNoEqualTo(stuNo);
        List<StudentQuery> studentQueries=new ArrayList<>();
        //是否从数据表中取到数据
        studentQueries=studentQueryService.selectByExample(example);
//        StudentQuery studentQueries=studentQueryService.selectByPrimaryKey(stuNo);
        return studentQueries;

//        StudentExample example = new StudentExample();
//        StudentExample.Criteria criteria=example.createCriteria();
//        criteria.andDromNoEqualTo(stuNo);
//        List<Student> studentSelects=new ArrayList<>();
//        studentSelects=StudentQueryService.selectByExample(example);
//        return studentSelects;

    }
}
