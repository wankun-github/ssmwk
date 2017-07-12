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

    <script src="js/userAction.js" type="text/javascript"></script>
    <link href="css/common.css" rel="stylesheet"/>
    <link href="css/font.css" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-default bg_blue">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>--%>
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="img/logo.png">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="menuBlueChoose"><a href="#" class="c_white">user<span class="sr-only">(current)</span></a></li>
                <li class="menuBlue" ><a href="#" class="c_white">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <div class="navbar-form navbar-left">
                <div class="form-group">
                    <input id="searchKey" type="text" class="form-control" placeholder="Search">
                </div>
                <button id="searchBtn" type="button" class="btn btn-default btn-lg">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                </button>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="menuBlue">
                    <a href="#" class="c_white" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <c:if test="${sessionScope.SESSION_USER_NAME != null}">
                            ${sessionScope.SESSION_USER_NAME }
                        </c:if>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a id="logoutBtn">注销</a></li>
                        <li><a href="#">action</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="row">
    <div align="right" class="col-md-6 col-md-offset-3">
        <button id="userAddBtn" type="button" class="btn btn-default" aria-label="Left Align">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        </button>
    </div>
    <div class="col-md-6 col-md-offset-3">
        <table id="userListTable" class="table table-striped table-hover">

        </table>
    </div>
</div>

<!--模态框 start-->
<div class="modal fade" id="userAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="userAddModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form id="addForm" action="user/saveUser" method="post">
                    <table class="table table-striped">
                        <tr>
                            <td>用户名：</td>
                            <td><input type="text" name="userName"></td>
                        </tr>
                        <tr>
                            <td>密码：</td>
                            <td><input type="password" name="userPassword"></td>
                        </tr>
                        <tr>
                            <td>年龄：</td>
                            <td><input type="text" name="userAge"></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <button id="addSubmit" type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                                </button>
                                <button type="backBtn" class="btn btn-default" data-dismiss="modal" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<!--模态框 end-->
<!--模态框 start-->
<div class="modal fade" id="userUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="userUpdateModalLabel">修改用户</h4>
            </div>
            <div class="modal-body">
                <form id="updateForm" action="user/updateUser" method="post" >
                    <input id="updateUserId" type="hidden" name="userId" value="">
                    <table class="table table-striped">
                        <tr>
                            <td>用户名：</td>
                            <td><input id="updateUserName" type="text" name="userName" value=""></td>
                        </tr>
                        <tr>
                            <td>密码：</td>
                            <td><input id="updateUserPassword" type="password" name="userPassword" value=""></td>
                        </tr>
                        <tr>
                            <td>年龄：</td>
                            <td><input id="updateUserAge" type="text" name="userAge" value=""></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <button id="udpateSubmit" type="button" class="btn btn-default" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                                </button>
                                <button type="backBtn" class="btn btn-default" data-dismiss="modal" aria-label="Left Align">
                                    <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                                </button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
<!--模态框 end-->
</body>
</html>
