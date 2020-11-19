package com.hbxy.ssm.app.repair.controller;

import com.hbxy.ssm.app.repair.model.Repair;
import com.hbxy.ssm.app.repair.model.RepairExample;
import com.hbxy.ssm.app.repair.service.RepairService;
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

public class RepairController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("/aprepairlist")
    public String lists(){
        return "app/ap_repair_list";
    }
    @RequestMapping(value = "/repair",method = RequestMethod.GET)
    public @ResponseBody
    Object repair(Model model, HttpServletRequest request){
        RepairExample example=new RepairExample();
        List<Repair> repair=new ArrayList<>();
        repair=repairService.selectByExample(example);
        return repair;
    }
    // @Transactional:spring数据库事务管理
    // 当有两个及以上的数据库表的添加/修改/删除操作时,要加上
    //添加报修信息
    @Transactional
    @RequestMapping(value = "/repair" , method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Repair repairRegister(@RequestBody Repair repair,
                          Model model, HttpServletRequest request){
//        Integer repairId= IdUtil.nextId().intValue();
        repair.setRepairId(repair.getRepairId());
        repair.setDormNo(repair.getDormNo());
//        repair.setRepairData(new Timestamp(System.currentTimeMillis()));

        //时间格式的
        //获取系统当前时间
        Timestamp time= new Timestamp(System.currentTimeMillis());
        //更改时间格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转化为String型
        String timeStr = df.format(time);
//        System.out.println(timeStr);
        //设置正确的时间
        repair.setRepairData(timeStr);

        repair.setRepairContent(repair.getRepairContent());
        repairService.insert(repair);
        return repair;
    }
    //修改报修信息
    @Transactional
    @RequestMapping(value = "/repair" , method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Repair repairEdit(@RequestBody Repair repair,
                                           Model model, HttpServletRequest request){
        repair.setDormNo(repair.getDormNo());
        repair.setRepairData(repair.getRepairData());
        repair.setRepairContent(repair.getRepairContent());
        repairService.updateByPrimaryKeySelective(repair);
        return repair;
    }
    //删除报修信息
    @Transactional
    @RequestMapping(value = "/repair/{repairId}",method = RequestMethod.DELETE)
    public @ResponseBody Object repairDel(@PathVariable Integer repairId,
                                          Model model, HttpServletRequest request){
//        Repair repair=new Repair();
//        repair.setRepairId(repairId);
        repairService.deleteByPrimaryKey(repairId);
        return 200;
    }
}
