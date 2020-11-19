package com.hbxy.ssm.admin.module.service.impl;

import com.hbxy.ssm.admin.module.mapper.AppMapper;
import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import com.hbxy.ssm.admin.module.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//将自动注册到Spring容器，不需要再在application.properties配置文件中定义bean了
//@Service注解也可以不指定serviceName,
// 如果不指定相当于<bean id="com.study.service.serviceName">，com.study.service.ServiceName就是这个类的全限定名,
// 不加的话，默认别名就是当前类名，但是首字母小写。
@Service

//实现类
public class AppServiceImpl implements AppService {

    //@Autowired注解的作用是解决对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    //扫描当前类中标注@Autowired的属性和方法；再查找父类中注@Autowired的属性和方法，依次遍历；
    @Autowired
    private AppMapper mapper;

    //  @Override是伪代码,表示重写
    @Override
                                                    //返回按条件计数的查询结果
    public long countByExample(AppExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AppExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(App record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(App record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<App> selectByExample(AppExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public App selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(App record, AppExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(App record, AppExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(App record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(App record) {
        return mapper.updateByPrimaryKey(record);
    }

}
