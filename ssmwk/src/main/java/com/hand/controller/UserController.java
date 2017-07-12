package com.hand.controller;

import com.github.pagehelper.PageHelper;
import com.hand.model.User;
import com.hand.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wankun on 2017/7/6.
 */
@Controller
@RequestMapping("/user")
public class UserController{

    @Resource
    private UserService userService;

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/queryAllUser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,List<User>> queryAllUser(){
        Map<String,List<User>> resultMap = new HashMap<String,List<User>>();
        PageHelper.startPage(1,5);
        List<User> userList = userService.queryAllUser();
        resultMap.put("userList",userList);
        return resultMap;
    }

    /**
     * 获取用户列表
     */
    @RequestMapping(value = "/queryUserByKey",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,List<User>> queryUserByKey(String searchKey){
        Map<String,List<User>> resultMap = new HashMap<String,List<User>>();
        List<User> userList = userService.queryUserByKey(searchKey);
        resultMap.put("userList",userList);
        return resultMap;
    }

    /**
     * 添加用户
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(HttpServletRequest request, User user){
        userService.saveUser(user);
        return "user/userList";
    }

    /**
     * 根据id刪除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/removeUser",method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("id") Integer id){
        userService.removeUser(id);
        return "user/userList";
    }

    /**
     * 跳转到用户修改页面
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/toUserUpdate",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,User> toUserUpdate(HttpServletRequest request,@PathVariable("id") Integer id){
        User user = userService.queryUserById(id);
        //request.setAttribute("user",user);
        //return "/user/userUpdate";
        Map<String,User> resultMap = new HashMap<String,User>();
        resultMap.put("user",user);
        return resultMap;
    }

    /**
     * 修改用户
     * @param request
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public String udpateUser(HttpServletRequest request,User user){
        userService.updateUser(user);
        return "user/userList";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "home/login";
    }

}
