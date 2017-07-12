package com.hand.controller;

import com.hand.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping("/user")
	public String toIndex(HttpServletRequest request,Model model){
	        
		return "user";
	}
	@RequestMapping("/saveUser")
	public String saveUser(HttpServletRequest request,Model model){

		return "saveUser";
	}
}
