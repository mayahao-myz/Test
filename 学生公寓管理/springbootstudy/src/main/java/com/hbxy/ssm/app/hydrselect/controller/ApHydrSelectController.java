package com.hbxy.ssm.app.hydrselect.controller;

import com.hbxy.ssm.app.hydrselect.model.ApHydrSelect;
import com.hbxy.ssm.app.hydrselect.model.ApHydrSelectExample;
import com.hbxy.ssm.app.hydrselect.service.ApHydrSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/app")
public class ApHydrSelectController {
    @Autowired
    private ApHydrSelectService apHyselectService;

    @RequestMapping("/aphydrselect")
    public String lists(Model model, HttpServletRequest request) {
        return "/app/ap_hydrselect";
    }

    //查询用户
   /* @Transactional
    @RequestMapping(value = "/hydrselect1", method = RequestMethod.GET)
    public @ResponseBody
    Object hydrs(Model model, HttpServletRequest request) {
        ApHydrSelectExample example = new ApHydrSelectExample();
        List<ApHydrSelect> hydrs = new ArrayList<>();
        hydrs = apHyselectService.selectByExample(example);
        return hydrs;
    }*/

    //条件查询
    @RequestMapping(value = "/hydrselect1/{dromNo}", method = RequestMethod.GET)
    public @ResponseBody
    Object hydrselect2(@PathVariable("dromNo") String dromNo, Model model, HttpServletRequest request) {
        ApHydrSelectExample example = new ApHydrSelectExample();
        ApHydrSelectExample.Criteria criteria=example.createCriteria();
        criteria.andDromNoEqualTo(dromNo);
        List<ApHydrSelect> apHydrSelects=new ArrayList<>();
        apHydrSelects=apHyselectService.selectByExample(example);
        return apHydrSelects;
    }
}