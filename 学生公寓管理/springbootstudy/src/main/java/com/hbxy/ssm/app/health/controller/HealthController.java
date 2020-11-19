package com.hbxy.ssm.app.health.controller;

import com.hbxy.ssm.app.health.model.Health;
import com.hbxy.ssm.app.health.model.HealthExample;
import com.hbxy.ssm.app.health.service.HealthService;
import com.hbxy.ssm.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/app")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @RequestMapping("/aphealth")
    public String health(Model model,HttpServletRequest request){
        return "app/ap_health";
    }
    //查询
    @RequestMapping(value = "health",method = RequestMethod.GET)
    @ResponseBody
    public List<Health> healthGet(HttpServletRequest request){
        List<Health> list = new ArrayList<>();
        HealthExample example = new HealthExample();
        list = healthService.selectByExample(example);
        return list;
    }
    //添加
    @RequestMapping(value = "/health",method = RequestMethod.POST,produces = "application/json")
    @Transactional
    @ResponseBody
    public Health healthAdd(@RequestBody Health health,HttpServletRequest request){

        health.setHealthId(health.getHealthId());
        health.setDormNo(health.getDormNo());
//        health.setHealthData(new Timestamp(System.currentTimeMillis()));
        //时间格式的
        //获取系统当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());
        //更改时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转化为String型
        String timeStr = df.format(time);
//        System.out.println(timeStr);
        //设置正确的时间
        health.setHealthData(timeStr);

        health.setHealthGrade(health.getHealthGrade());
        health.setHealthRemark(health.getHealthRemark());

        healthService.insert(health);
        return health;
    }
    //修改
    @RequestMapping(value = "/health",method = RequestMethod.PUT,produces = "application/json")
    @Transactional
    @ResponseBody
    public Health healthEdit(@RequestBody Health health,HttpServletRequest request){

        health.setDormNo(health.getDormNo());
        health.setHealthData(health.getHealthData());
        health.setHealthGrade(health.getHealthGrade());
        health.setHealthRemark(health.getHealthRemark());

        healthService.updateByPrimaryKeySelective(health);
        return health;
    }
    //删除
    @RequestMapping(value = "/health/{healthId}",method = RequestMethod.DELETE,produces = "application/json")
    @Transactional
    @ResponseBody
    public Object healthDelete(@PathVariable("healthId") int healthId,HttpServletRequest request){
        Health health = new Health();
        health.setHealthId(healthId);
        healthService.deleteByPrimaryKey(healthId);
        return "200";
    }
}
