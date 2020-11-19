package com.hbxy.ssm.app.dorm.controller;

import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.app.dorm.model.Dorm;
import com.hbxy.ssm.app.dorm.model.DormExample;
import com.hbxy.ssm.app.dorm.service.DormService;

import com.hbxy.ssm.util.IdUtil;

import com.hbxy.ssm.util.UserLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//js允许跨域访问?
@CrossOrigin
@Controller
@RequestMapping("/app")
public class DormController {

    @Autowired
    private DormService DormService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleRightService roleRightService;

    //进入模块,RequestMapping后，返回值通常解析为跳转路径，
    @RequestMapping("/dormlist")
    public String DormList(){
        return"/app/dorm_list";
    }

    //查询宿舍号
    // Transactional:spring数据库事务管理,当有两个及以上的数据库表的添加/修改/删除操作时,要加上
    @RequestMapping(value = "dorm",method = RequestMethod.GET)
    public @ResponseBody
    Object DormGet(Model model,HttpServletRequest request){
        List<Dorm> list=new ArrayList<>();
        DormExample DormExample=new DormExample();
//        DormExample.Criteria criteria=DormExample.createCriteria();
//        criteria.andCurrentStatusEqualTo("0");
//        DormExample.setOrderByClause("order_index");
        list=DormService.selectByExample(DormExample);
        return list;
    }
    //添加宿舍号
//    @Transactional
//    @RequestMapping(value = "/dorm",method = RequestMethod.POST,produces ="application/json")
//    public @ResponseBody
//    Object DormAdd(@RequestBody Dorm dorm,Model model,HttpServletRequest request){
//        String dormno= IdUtil.nextId().toString();
//        dorm.setDormNo(dormno);
////        DormService.insert(dorm);
//        return dorm;//json格式数据
//    }

    //添加
    @RequestMapping(value = "/dorm",method = RequestMethod.POST, produces = "application/json")//表示将生产json格式的数据，
    public @ResponseBody
    Object DormAdd(@RequestBody Dorm Dorm,
                        Model model, HttpServletRequest request){//@RequestBody Equipment通过@RequestBody接收json格式数据
//        String id= IdUtil.nextId().toString();
//        Dorm.setDormNo(id);
//        Dorm.setDormNo(UserLoginUtil.getUserLogin(request).getUserLoginId());
        Dorm.setDormNo(Dorm.getDormNo());
        DormService.insert(Dorm);

        return Dorm;//json格式数据
    }

    //修改信息
    @RequestMapping(value = "/dorm",method = RequestMethod.PUT,produces = "application/json")
    public @ResponseBody
    Object DormEdit(@RequestBody Dorm Dorm,
                    Model model,
                    HttpServletRequest request ){
//        DormService.updateByPrimaryKeySelective(Dorm);
//        DormService.updateByExampleSelective(Dorm,DormExample);
//        Dorm.setDormNo(Dorm.getDormNo());
//        DormService.updateByExampleSelective(Dorm);
        //更新模块表中关联的子系统名称
        Module module = new Module();
        module.setAppName(Dorm.getDormNo());//设置要修改的内容
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(Dorm.getDormNo());//设置条件
        //根据条件，有选择的更新内容
        moduleService.updateByExampleSelective(module,moduleExample);

        return Dorm;
    }
//        if(dorm.getDormNo()!=null || !"".equalsIgnoreCase(dorm.getDormNo()))
//        {
//            dorm.setDormNo(dorm.getDormNo());
//        }
//        dorm.setDormNo(dorm.getDormNo());
//        dormService.updateByPrimaryKeySelective(dorm);
//        return dorm;
//    }

    //删除
    @RequestMapping(value = "/dorm/{id}",method = RequestMethod.DELETE)
    public @ResponseBody
    Object DormDelete(@PathVariable String id,
                      Model model,
                      HttpServletRequest request){

            DormService.deleteByPrimaryKey(id);
        //查询出关联的模块
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(id);

        List<Module> moduleList = moduleService.selectByExample(moduleExample);

        //删除模块表关联的模块
        //根据条件删除子表记录
        moduleService.deleteByExample(moduleExample);
        //删除与角色相关联的模块(role_right表里的数据)
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

//        //真删除
//        Dorm dorm=new Dorm();
//        dorm.setDormNo(dormNo);
//        DormService.deleteByPrimaryKey(dorm.getDormNo());
//        return 200;

    }

}
