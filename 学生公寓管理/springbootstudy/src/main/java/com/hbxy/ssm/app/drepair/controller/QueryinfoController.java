package com.hbxy.ssm.app.drepair.controller;

import com.hbxy.ssm.app.drepair.model.Drepair;
import com.hbxy.ssm.app.drepair.model.DrepairExample;
import com.hbxy.ssm.app.drepair.service.DrepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/app")

//维修查询
public class QueryinfoController {
    @Autowired
    private DrepairService drepairService;
//响应的入口路劲
    @RequestMapping("/myquery")
    public String lists(){
        return "app/ap_query_info";
    }
    @RequestMapping(value = "/query/{dormNo}",method = RequestMethod.GET)
    public @ResponseBody
    Object repair(@PathVariable(value = "dormNo")String dormNo ,Model model, HttpServletRequest request){

        DrepairExample example=new DrepairExample();
        DrepairExample.Criteria criteria = example.createCriteria();
        criteria.andDormNoLike(dormNo);
        List<Drepair> drepair=new ArrayList<>();
        drepair= drepairService.selectByExample(example);
        return drepair;
    }
}
