<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>学生公寓系统登录</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/custom/mx-login.css"/>
</head>
<body>
<div class="body-main">
  <div class="login-main">
    <h2 align="center">学生公寓系统登录</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
      <div>
        <span style="padding-left: 20px">账号</span>
        <input type="text" id="userLoginId" name="userLoginId" placeholder="请输入帐号">
      </div>
      <div>
        <span style="padding-left: 20px">密码</span>
        <input type="password" id="currentPassword" name="currentPassword" placeholder="请输入密码">
      </div>
<%--      先单选按钮，再字--%>
<%--      <div height="86px">--%>
<%--          <tr id="RadioButtonList1">--%>
<%--            <td>--%>
<%--                <input class="select-button" id="RadioButtonList1_0" type="radio" name="RadioButtonList1" value="管理员" tabindex="4" />--%>
<%--                <label class="select-button" for="RadioButtonList1_0">管理员</label>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--              <input class="select-button" id="RadioButtonList1_1" type="radio" name="RadioButtonList1" value="宿管" tabindex="4" />--%>
<%--              <label class="select-button" for="RadioButtonList1_1">宿管</label>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--              <input class="select-button" id="RadioButtonList1_2" type="radio" name="RadioButtonList1" value="学生" checked="checked" tabindex="4" />--%>
<%--              <label class="select-button" for="RadioButtonList1_2">学生</label>--%>
<%--            </td>--%>
<%--            <div></div>--%>
<%--            <td>--%>
<%--              <input class="select-button" id="RadioButtonList1_3" type="radio" name="RadioButtonList1" value="纪检人员" tabindex="4" />--%>
<%--              <label class="select-button" for="RadioButtonList1_3">纪检员</label>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--              <input class="select-button" id="RadioButtonList1_4" type="radio" name="RadioButtonList1" value="维修人员" tabindex="4"/>--%>
<%--              <label class="select-button" for="RadioButtonList1_4">维修员</label>--%>
<%--            </td>--%>
<%--          </tr>--%>
<%--      </div>--%>
      <div class="errormsg">
        &nbsp;${msg}
      </div>
      <div class="btn_login">
        <input type="submit" value="登录">
        <input type="reset" value="取消">
      </div>
      <div>
        &nbsp;
      </div>
    </form>
  </div>
</div>
</body>
</html>
