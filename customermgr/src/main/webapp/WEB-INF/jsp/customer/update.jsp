<%--
  Created by IntelliJ IDEA.
  User: miaoshengliu
  Date: 2018/12/15
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.request.contextPath}/customer/update" method="post">
    <table width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine">
        <input type="hidden" name="uuid" value="${cm.uuid}">
        <input type="hidden" name="registerTime" value="${cm.registerTime}">
        <tr>
            <td colspan=4 align=center class="tableLineBg">客户新增</td>
        </tr>
        <tr>
            <td>客户编号</td>
            <td><input type="text" name="customerId" value="${cm.customerId}" class="input"></td>
            <td>客户密码</td>
            <td><input type="text" name="pwd" value="${cm.pwd}" class="input"></td>
        </tr>
        <tr>
            <td>显示名称</td>
            <td><input type="text" name="showName" value="${cm.showName}" class="input"></td>
            <td>真实姓名</td>
            <td><input type="text" name="trueName" value="${cm.trueName}" class="input"></td>
        </tr>
        <tr>
            <td colspan=4 align=center><input type="submit" value="更新" class="button"></td>
        </tr>
    </table>
</form>
</body>
</html>
