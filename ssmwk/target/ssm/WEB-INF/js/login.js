var customBasePath = document.getElementsByTagName("base")[0].getAttribute("href");
$(document).ready(function () {
    $("#login_btn").click(function () {
        var userName = $("#userName").val();
        var userPassword = $("#userPassword").val();
        var validateCode = $("#validateCode").val();
        if(validateCode != null && validateCode != ""){
            //alert(validateCode);
            if(userName == null || userName == ""){
                //alert(userName);
                $('#userName').popover('toggle');
            }else if(userPassword == null || userPassword == ""){
                //alert(userPassword);
                $('#userPassword').popover('toggle');
            }else{
                $.ajax({
                    type : "POST",
                    url : "login/login",
                    data : {"validateCode":validateCode,"userName":userName,"userPassword":userPassword},
                    //dataType : 'json',
                    async : true,
                    cache : false,
                    success : function (response) {
                        //var user = response.user;
                        var msg = response.msg;
                        if(msg != null && msg != ""){
                            $("#loginMsg").text(msg);
                            $('#myModal').modal('show');
                            changeImg();
                        }else{
                            window.location.href=customBasePath+ "common/toHtml?pageName=user/userList";
                        }
                    }

                });
            }
        }else{
            $('#validateCode').popover('toggle');
        }

    });
});
// 刷新图片
function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", changeUrl(src));
}
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function changeUrl(url) {
    var timestamp = (new Date()).valueOf();
    var index = url.indexOf("?",url);
    if (index > 0) {
        url = url.substring(index, url.indexOf(url, "?"));
    }
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}
$(function () { $("[data-toggle='popover']").popover(); });