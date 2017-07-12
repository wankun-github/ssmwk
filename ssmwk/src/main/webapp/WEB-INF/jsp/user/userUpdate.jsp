<%--
  Created by IntelliJ IDEA.
  User: wankun
  Date: 2017/7/6
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
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
    <title>ADD USER</title>
    <!-- Bootstrap -->
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <script src="js/userAction.js" type="text/javascript"></script>
</head>
<body>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id="updateForm" action="user/updateUser" method="post" >
                <input type="hidden" name="userId" value="${requestScope.user.userId}">
                <table class="table table-striped">
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" name="userName" value="${requestScope.user.userName}"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="userPassword" value="${requestScope.user.userPassword}"></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="userAge" value="${requestScope.user.userAge}"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button id="udpateSubmit" type="button" class="btn btn-default" aria-label="Left Align">
                                <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                            </button>
                            <button type="backBtn" class="btn btn-default" aria-label="Left Align">
                                <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                            </button>
                            <%--<input type="submit" value="save">--%>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</body>
</html>
