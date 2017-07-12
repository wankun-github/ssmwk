package com.hand.controller;

import com.hand.model.User;
import com.hand.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wankun on 2017/7/10.
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpSession httpSession, HttpServletRequest request, String validateCode, String userName, String userPassword){
        HttpSession session = request.getSession();
        String sessionCode = (String) session.getAttribute("code");
        System.out.println("code:"+validateCode+"===sessioncode:"+sessionCode);
        Map<String,Object> info = new HashMap<String,Object>();
        if (!StringUtils.equalsIgnoreCase(validateCode, sessionCode)) {  //忽略验证码大小写
            info.put("msg","验证码不正确");
        }else{
            User user = userService.getUserByNameAndPwd(userName,userPassword);
            if(user == null){
                info.put("msg","用户名或密码不正确");
            }else{
                info.put("user",user);
                httpSession.setAttribute("SESSION_USER_NAME",user.getUserName());
            }
        }
        return info;
    }
    /**
     * 用户注销
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("SESSION_USER_NAME");
        return "home/login";
    }
}
