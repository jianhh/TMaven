package com.wego.tmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wego.tmaven.entity.User;
import com.wego.tmaven.service.UserService;

@Controller
@RequestMapping("user")
public class UserCtrl extends BaseController{
	
	@Autowired
	UserService userService;

	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "front/index";
	}
	
	
	@RequestMapping(value="save",method = RequestMethod.GET)
	public String save(User user){
		System.out.println(user);
		String text = userService.save(user);
		System.out.println(text);
		this.set("message", user+text);
		return "front/message";
	}
}
