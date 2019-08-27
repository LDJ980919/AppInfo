package cn.appsys.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.BackendUserService;
import cn.appsys.service.UserService;

@Controller
public class LoginController {
	
	private Logger log = Logger.getLogger(LoginController.class);
	@Resource
	private UserService userService;
	@Resource
	private BackendUserService backendUserService;
	
	/**
	 * 系统首页,选择入口页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "loginApp";
	}
	/**
	 * 开发者登入
	 * @return
	 */
	@RequestMapping(value="/devuser",method=RequestMethod.GET)
	public String devUser(){
		return "devUser/login";
	}
	/**
	 * 开发者登录查询
	 * @param devCode
	 * @param devPassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/devuserSave",method=RequestMethod.POST)
	public String devUserSave(DevUser user, Model model){
		log.info("进入devUserSave方法,账号为:"+user);
		String error = "";
		Integer result = userService.getDevUserLogin(user);
		log.info("账号数量为result=======>"+result);
		if(result != null){
			return "index";
		}else {
			error = "用户名或密码错误,请重新输入!";
			model.addAttribute("error", error);
			return "devUser/login";
		}
	}
	/**
	 * 管理员登入
	 * @return
	 */
	@RequestMapping(value="/backenduser",method=RequestMethod.GET)
	public String backendUser(){
		return "backendUser/login";
	}
	/**
	 * 管理员登录判断
	 * @param userCode
	 * @param userPassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/backendUserSave",method=RequestMethod.POST)
	public String backendUserSave(BackendUser user , Model model){
		log.info("进入backendUserSave方法,账号为:"+user);
		String error = "";
		Integer result = backendUserService.getBacUserLogin(user);
		log.info("账号数量为result=======>"+result);
		if(result != null){
			return "index";
		}else {
			error = "用户名或密码错误,请重新输入!";
			model.addAttribute("error", error);
			return "backendUser/login";
		}
	}
}
