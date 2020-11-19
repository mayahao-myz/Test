<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>公寓管理控制台</title>
  <!--引入图标库awesome.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/mx-custom.css">
</head>
<body>
<div class="mx-body-container">
  <!--左侧导航栏-->
  <div class="mx-left">
    <div class="mx-logo"><i class="fa fa-cubes"></i>公寓管理控制台</div>
    <div class="mx-nav">
      <ul>
        <li class="mx-menu">
          <div class="mx-menu-title"><i class="fa fa-sitemap"></i>组织人员管理</div>
          <ul class="mx-submenu">
            <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}/admin/userlist')"><i class="fa fa-user"></i>用户管理</li>
<%--            <li class="mx-menu-item"><i class="fa fa-sitemap"></i>学生信息管理</li>--%>
          </ul>
        </li>

        <li class="mx-menu">
          <div class="mx-menu-title"><i class="fa fa-th-large"></i>应用管理</div>
          <ul class="mx-submenu">
            <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}/admin/applist')"><i class="fa fa-th"></i>子系统管理</li>
            <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}/admin/modulelist')"><i class="fa fa-list-ol"></i>模块管理</li>
          </ul>
        </li>
        <li class="mx-menu">
          <div class="mx-menu-title"><i class="fa fa-cog"></i>权限管理</div>
          <ul class="mx-submenu">
            <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}/admin/rolelist')"><i class="fa fa-male"></i>角色管理</li>
            <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}/admin/roleuser')"><i class="fa fa-key"></i>授权管理</li>
          </ul>
        </li>
      </ul>
    </div>

  </div>
  <!--/左侧导航栏-->
  <!--页头-->
  <div class="mx-header">
    <div class="mx-header-title">
      <i class="fa fa-user-circle-o fa-lg"></i>
      <c:set var="userLogin" value="${sessionScope.USER_SESSION}" />
      <span class="mx-header-title">${userLogin.userName}</span>
<%--      <a onclick="" title="修改密码"><i class="fa fa-lock fa-lg"></i></a>&nbsp;&nbsp;--%>
      <a onclick="logout('${pageContext.request.contextPath}/logout')" title="退出系统"><i class="fa fa-sign-out fa-lg"></i></a>
    </div>
    <div class="mx-horizontal-split"></div>
  </div>
  <!--/页头-->
  <!--页面内容-->
  <div class="mx-main-content">
<%--   iframe 内容框架的定义--%>
    <iframe name="mxiframe" id="mxiframe" class="mx-iframe"
            src="${pageContext.request.contextPath}/admin/home"
            frameborder="0"
            align="left"
            scrolling="auto">
      <p>您的浏览器不支持iframe标签,请换成chrome或firefox浏览器使用本应用</p>
    </iframe>
  </div>
  <!--/页面内容-->
  <!--页脚-->
  <div class="mx-footer">
    <div class="mx-horizonta学生公寓管理系统l-split"></div>
    <div>Copyright ©2020  学生公寓管理系统</div>
  </div>
  <!--/页脚-->
</div>
<!--引入自定义js-->
<script src="${pageContext.request.contextPath}/static/custom/mx-custom.js"></script>
</body>
</html>
