<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>应用首页框架</title>
  <!--引入图标库awesome.css-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/mx-custom.css">
</head>
<body>
<div class="mx-body-container">

<%--  学生的+维修人员的+纪检人员的--%>

  <!--左侧导航栏-->
  <div class="mx-left">
    <div class="mx-logo"><i class="fa fa-cubes"></i>公寓管理应用系统</div>
    <div class="mx-nav">
      <ul>
        <!--构造菜单-->
        <!--1 先从session取得数据-->
<%--        获得相应的子系统的子模块功能--%>
        <c:set var="applist" value="${sessionScope.right_app}"></c:set>
        <c:set var="modulelist" value="${sessionScope.right_module}"></c:set>
        <!--2 两次循环，构造菜单-->
        <c:forEach var="app" items="${applist}">
          <li class="mx-menu">
            <div class="mx-menu-title"><i class="fa fa-th-large"></i>${app.appName}</div>
            <ul class="mx-submenu">
              <c:forEach var="module" items="${modulelist}">
                <c:if test="${app.appId.equalsIgnoreCase(module.appId)}">
                  <li class="mx-menu-item" onclick="changeto('${pageContext.request.contextPath}${module.moduleUrl}')"><i class="fa fa-th-list"></i>${module.moduleName}</li>
                </c:if>
              </c:forEach>
            </ul>
          </li>
        </c:forEach>
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
    <iframe name="mxiframe" id="mxiframe" class="mx-iframe"
            src="${pageContext.request.contextPath}/app/home"
            frameborder="0"
            align="left"
            scrolling="auto">
      <p>您的浏览器不支持iframe标签,请换成chrome或firefox浏览器使用本应用</p>
    </iframe>
  </div>
  <!--/页面内容-->
  <!--页脚-->
  <div class="mx-footer">
    <div class="mx-horizontal-split"></div>
    <div>Copyright ©2020 学生公寓管理系统</div>
  </div>
  <!--/页脚-->
</div>
<!--引入自定义js-->
<script src="${pageContext.request.contextPath}/static/custom/mx-custom.js"></script>
</body>
</html>
