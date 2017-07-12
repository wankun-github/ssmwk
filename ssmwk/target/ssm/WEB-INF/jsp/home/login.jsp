<%--
  Created by IntelliJ IDEA.
  User: wankun
  Date: 2017/7/10
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 在解析el表达式是一定要加上这一句话，否则不能解析 -->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <BASE href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>login</title>
    <!-- Bootstrap -->
    <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <link href="css/font.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet"/>
    <script src="js/login.js" type="text/javascript"></script>
</head>
  <body background="img/login_bg.jpg" style="background-size:cover">
	<div id="loginDiv">
      <form class="form-signin" method="POST">
        <h2 class="font_son">Please sign in</h2>
        <label for="userName" class="sr-only">账号</label>
        <div class="input-group">
	         <span class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
	         <input type="text"
                    name="userName" id="userName" class="user-input form-control"
                    placeholder="账号" data-toggle="popover" data-content="账号不能为空"
                    aria-describedby="basic-addon1" required autofocus>
        </div><br>
        <label for="userPassword" class="sr-only">密码</label>
        <div class="input-group">
	         <span class="input-group-addon"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
	         <input type="password"
                    name="userPassword" id="userPassword" class="user-input form-control"
                    placeholder="密码" data-toggle="popover" data-content="密码不能为空"
                    required>
        </div><br>
        <label for="validateCode" class="sr-only">验证码</label>
        <div class="input-group">
	         <span class="input-group-addon"><span class="glyphicon glyphicon-barcode" aria-hidden="true"></span></span>
             <input type="text"
                    id="validateCode" name="validateCode" class="validate-input form-control"
                    placeholder="验证码" data-toggle="popover" data-content="验证码不能为空"
                    required />
             <img id="imgObj" alt="验证码" src="validateCode/creatValidateCode" onclick="changeImg()"/>
             <%--<a onclick="changeImg()">换一张</a>--%>
        </div><br>
        <div class="row">
        <div class="col-md-1"></div>
		  <div class="col-md-4">
	        <button id="login_btn" class="btn btn-primary btn-block" type="button">登录</button>
		  </div>
		  <div class="col-md-4">
        	<button class="btn btn-primary btn-block" type="button" onclick="window.location.href=''">返回</button>
		  </div>
		 </div>
      </form>
    </div>
    <%--<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Launch demo modal
    </button>--%>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">提示</h4>
                </div>
                <div class="modal-body">
                    <p id="loginMsg"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
</html>