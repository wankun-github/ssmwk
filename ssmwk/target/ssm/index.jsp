<%--
  Created by IntelliJ IDEA.
  User: wankun
  Date: 2017/7/6
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge" >
    <BASE href="<%=basePath%>">
    <title>USER LIST1</title>
    <!-- Bootstrap -->
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<%--<a href="/common/tohtml/user">123</a>--%>
<a href="common/toHtml?pageName=user/userList" >userlist</a>
<a href="user/toLogin" >login</a>
<div class="row">
    <%--<div align="right" class="col-md-6 col-md-offset-3">
        <button id="userAddBtn" type="button" class="btn btn-default" aria-label="Left Align">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        </button>
    </div>
    <div class="col-md-6 col-md-offset-3">
        <table id="userListTable" class="table table-striped table-hover">

        </table>
    </div>--%>
</div>
</body>
</html>
