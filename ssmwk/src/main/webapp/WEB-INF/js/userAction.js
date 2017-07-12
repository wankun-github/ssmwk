var customBasePath = document.getElementsByTagName("base")[0].getAttribute("href");
window.onload = function () {
    queryUserList();
    $("#backBtn").click(function () {
        window.location.href=customBasePath+ "common/toHtml?pageName=user/userList";
    });
    $("#userAddBtn").click(function () {
        //window.location.href=customBasePath+ "common/toHtml?pageName=user/userAdd";
        $('#userAddModal').modal('show');
    });
    $("#udpateSubmit").click(function () {
        $("#updateForm").submit();
    });
    $("#addSubmit").click(function () {
        $("#addForm").submit();
    });
    $("#searchBtn").click(function () {
        queryUserListByKey();
    });
    $("#logoutBtn").click(function () {
        window.location.href=customBasePath+ "login/logout";
    });
}
//传入response中的user集合，响应到页面表格中
function tableUserList(response) {
    var userList = response.userList;
    var str = "<tr><th>编号</th><th>姓名</th><th>年龄</th><th>操作</th></tr>";
    for (var i=0;i<userList.length;i++){
        str += "<tr><td>"+userList[i].userId+"</td>"
            +"<td><span class='mouse_pointer' onclick='updateUserBtn("+userList[i].userId+")'>"+userList[i].userName+"</span></td>"
            +"<td>"+userList[i].userAge+"</td><td>"
            +"<button type='button' onclick='removeUserBtn("+userList[i].userId+")' class='btn btn-default' aria-label='Left Align'>"
            +"<span class='glyphicon glyphicon-minus' aria-hidden='true'></span>"
            +"</button></td></tr>";
    }
    $("#userListTable").text("");
    $("#userListTable").append(str)
}

function queryUserListByKey() {
    var searchKey = $("#searchKey").val();
    $.ajax({
        type : "POST",
        url : "user/queryUserByKey",
        data : {"searchKey":searchKey},
        async : true,
        cache : false,
        success : function(response){
            tableUserList(response);
        }

    });
}

function queryUserList() {
    $.ajax({
        type : "GET",
        url : "user/queryAllUser",
        async : true,
        cache : false,
        success : function(response){
            tableUserList(response);
        }
    });
}
function removeUserBtn(id) {
    if(confirm("确认删除吗")) {
        $.ajax({
            type: "DELETE",
            url: "user/" + id + "/removeUser",
            async: true,
            cache: false,
            success: function () {
                queryUserList();
            }
        });
    }else{}
}
function updateUserBtn(id) {
    $.ajax({
        type: "GET",
        url: "user/" + id + "/toUserUpdate",
        async: true,
        cache: false,
        success: function (response) {
            var user = response.user;
            $("#updateUserId").val(user.userId);
            $("#updateUserName").val(user.userName);
            $("#updateUserPassword").val(user.userPassword);
            $("#updateUserAge").val(user.userAge);
        }
    });
    $('#userUpdateModal').modal('show');
    //window.location.href=customBasePath+ "user/"+id+"/toUserUpdate";
}