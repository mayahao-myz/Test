package com.hbxy.ssm.app.health.controller;

import com.hbxy.ssm.app.health.model.Health;
import com.hbxy.ssm.app.health.model.HealthExample;
import com.hbxy.ssm.app.health.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app")
public class HealthSelectController {

    @Autowired
    private HealthService healthService;

    @RequestMapping("/healthselect")
    public String healthselect(Model model, HttpServletRequest request){
        return "app/health_select";
    }

    //查询
    @RequestMapping(value = "/healthselect1",method = RequestMethod.GET)
    @ResponseBody
    public List<Health> select1Get(HttpServletRequest request){
        List<Health> list = new ArrayList<>();
        HealthExample example = new HealthExample();
        list = healthService.selectByExample(example);
        return list;
    }
    //查询
    @RequestMapping(value = "/healthselect2/{dromNo}",method = RequestMethod.GET)
    public @ResponseBody
    Object healthselect2 (@PathVariable("dromNo") String dromNo,HttpServletRequest request){
        HealthExample example = new HealthExample();

        HealthExample.Criteria criteria = example.createCriteria();
        criteria.andDormNoLike(dromNo);

        List<Health> list = new ArrayList<>();
        list = healthService.selectByExample(example);
        return list;
    }
}
