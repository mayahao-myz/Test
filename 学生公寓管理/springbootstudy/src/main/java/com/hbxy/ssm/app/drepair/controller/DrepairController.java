package com.hbxy.ssm.app.drepair.controller;

import com.hbxy.ssm.app.drepair.model.Drepair;
import com.hbxy.ssm.app.drepair.model.DrepairExample;
import com.hbxy.ssm.app.drepair.service.DrepairService;
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
public class DrepairController {
    @Autowired
    private DrepairService drepairService;
    @RequestMapping("/apdrepairlist")
    public String lists(){
        return "app/ap_drepair_list";
    }
    @RequestMapping(value = "/drepair",method = RequestMethod.GET)
    public @ResponseBody
    Object repair(Model model, HttpServletRequest request){
        DrepairExample example=new DrepairExample();
        List<Drepair> drepair=new ArrayList<>();
        drepair=drepairService.selectByExample(example);
        return drepair;
    }
    // @Transactional:spring数据库事务管理
    // 当有两个及以上的数据库表的添加/修改/删除操作时,要加上
    //添加维修信息
    @Transactional
    @RequestMapping(value = "/drepair" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Drepair drepairRegister(@RequestBody Drepair drepair,
                            Model model, HttpServletRequest request){
        //维修编号，不显示，无处用到
        Integer drepairId= IdUtil.nextId().intValue();
        drepair.setDrepairId(drepairId);
        drepair.setRepairId(drepair.getRepairId());
        drepair.setDormNo(drepair.getDormNo());
//        drepair.setDrepairData(new Timestamp(System.currentTimeMillis()));
        //时间格式的
        //获取系统当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());
        //更改时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转化为String型
        String timeStr = df.format(time);
//        System.out.println(timeStr);
        //设置正确的时间
        drepair.setDrepairData(timeStr);


        drepair.setRepairContent(drepair.getRepairContent());
        drepair.setDrepairState(drepair.getDrepairState());
        drepairService.insert(drepair);
        return drepair;
    }
    //修改报修信息
    @Transactional
    @RequestMapping(value = "/drepair" , method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    Drepair drepairEdit(@RequestBody Drepair drepair,
                        Model model, HttpServletRequest request){
        drepair.setRepairId(drepair.getRepairId());
        drepair.setDormNo(drepair.getDormNo());
        drepair.setDrepairData(drepair.getDrepairData());
        drepair.setRepairContent(drepair.getRepairContent());
        drepair.setDrepairState(drepair.getDrepairState());
        drepairService.updateByPrimaryKeySelective(drepair);
        return drepair;
    }
    //删除报修信息
    @Transactional
    @RequestMapping(value = "/drepair/{drepairId}")
    public @ResponseBody Object drepairDel(@PathVariable("drepairId") Integer drepairId,
                                           Model model, HttpServletRequest request){
        Drepair drepair=new Drepair();
        drepair.setRepairId(drepairId);
        drepairService.deleteByPrimaryKey(drepair.getDrepairId());
        return 200;
    }
}
