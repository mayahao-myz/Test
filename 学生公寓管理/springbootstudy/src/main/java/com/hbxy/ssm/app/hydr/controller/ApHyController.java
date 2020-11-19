package com.hbxy.ssm.app.hydr.controller;


import com.hbxy.ssm.app.hydr.model.ApHydr;
import com.hbxy.ssm.app.hydr.model.ApHydrExample;
import com.hbxy.ssm.app.hydr.service.ApHyService;
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
public class ApHyController {
    @Autowired
    private ApHyService apHyService;
    @RequestMapping("/aphydr")
    public String lists(Model model, HttpServletRequest request){
        return "/app/ap_hydr";
    }
    //查询用户
    @Transactional
    @RequestMapping(value ="hydr",method = RequestMethod.GET)
    public @ResponseBody
    Object hydrs(Model model,HttpServletRequest request){
        ApHydrExample example=new ApHydrExample();
        List<ApHydr> hydrs=new ArrayList<>();
        hydrs=apHyService.selectByExample(example);
        return hydrs;
    }
//添加
    @RequestMapping(value = "/hydr",method = RequestMethod.POST,produces = "application/json")
    public  @ResponseBody
    ApHydr apHydrRegister(@RequestBody ApHydr apHydr, Model model,
                          HttpServletRequest request){
        apHydr.setHydrId(apHydr.getHydrId());
        apHydr.setDromNo(apHydr.getDromNo());
//        apHydr.setHydrData(apHydr.getHydrData());
        //时间格式的
        //获取系统当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());
        //更改时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转化为String型
        String timeStr = df.format(time);
//        System.out.println(timeStr);
        //设置正确的时间
        apHydr.setHydrData(timeStr);

        apHydr.setHydrFree(apHydr.getHydrFree());
        apHydr.setHydrFreeState(apHydr.getHydrFreeState());
        apHyService.insert(apHydr);
        return apHydr;
    }
    //修改信息
    @Transactional
    @RequestMapping(value = "/hydr",method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody


    ApHydr hydrEdit(@RequestBody ApHydr apHydr,Model model,
                    HttpServletRequest request){
        apHydr.setHydrId(apHydr.getHydrId());
        apHydr.setDromNo(apHydr.getDromNo());
//        apHydr.setHydrData(apHydr.getHydrData());
        //时间格式的
        //获取系统当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());
        //更改时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转化为String型
        String timeStr = df.format(time);
//        System.out.println(timeStr);
        //设置正确的时间
        apHydr.setHydrData(timeStr);

        apHydr.setHydrFree(apHydr.getHydrFree());
        apHydr.setHydrFreeState(apHydr.getHydrFreeState());
        apHyService.updateByPrimaryKeySelective(apHydr);
        return apHydr;
    }
    //删除用户
    @Transactional
    @RequestMapping(value = "/hydr/{HydrId}")
    public @ResponseBody
    Object hydrDel(@PathVariable("HydrId") Integer HydrId,
                   Model model, HttpServletRequest request) {
        //真删除
        ApHydr apHydrRecord = new ApHydr();
        apHydrRecord.setHydrId(HydrId);
        apHyService.deleteByPrimaryKey(apHydrRecord.getHydrId());
        return "200";
    }
}
