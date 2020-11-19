package com.hbxy.ssm.login.interceptor;

import com.hbxy.ssm.admin.user.model.UserLogin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

public class LoginInterceptor implements HandlerInterceptor {
    //不拦截的url:有些url不需要进行拦截
    public static final HashSet<String> IGNORE_URI = new HashSet<String>() {{
        add("/login");//登录
        add("/noright");
        add("/sba");
        add("/error");//错误
    }};

    // 该方法将在 Controller 处理前进行调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // flag 表示是否登录
        boolean flag = false;
        // 获取请求的 URL
        String url = request.getServletPath();

        //1 首先判断进来的url是否在忽略的列表里
        // 如果在,则不需要登录,允许通过
        if(IGNORE_URI.contains(url)) {
            flag = true;
        }else{
            // 2 开始进行认证和鉴权
            // 2.1 身份认证: 通过获取 Session 并判断是否已经登录
            //setAttribute 保存数据
            UserLogin userLogin =
                    (UserLogin)request.getSession().getAttribute("USER_SESSION");
            if (userLogin == null) {
                // 如果未登录，直接跳转到登录页面
                request.setAttribute("message", "请先登录!");
                response.sendRedirect(request.getContextPath()+"/login");
            } else {
                // 2.2 如果已经登录,则要进行权限判断(鉴权):
                //     判断当前用户是否有权限访问这个url(也就是功能模块的入口url)
                if ("1".equalsIgnoreCase(userLogin.getIsSystem()) || "2".equalsIgnoreCase(userLogin.getIsSystem())) {
                    //2.2.1 系统管理员暂时不用鉴权
                    flag = true;
                }else{
                    flag = true;
//                    //2.2.2 普通用户:判断请求的url是否在权限列表
//                    RightManager rightManager =new RightManager();
//                    if(rightManager.hasRightByUrl(request)){
//                        // 如果该用户的权限列表中包含有这个url,则允许通过拦截器
//                        flag = true;
//                    }else{
//                        // 否则,即判断其没有权限访问该url,跳转到一个页面,提示没有权限
//                        response.sendRedirect(request.getContextPath()+"/noright");
//                    }
                }
            }
        }
        //3 最后通过判断flag,是否允许通过拦截器:true-允许;false-不允许
        return flag;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
