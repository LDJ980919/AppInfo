package cn.appsys.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.appsys.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getIndex(){
		return "user/index";
	}
	
	private Logger log = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	/**
	 * 系统首页,选择入口页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "user/login";
	}
	
	public String devUser(){
		return "";
	}
}
