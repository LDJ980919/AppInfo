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
	 * ϵͳ��ҳ,ѡ�����ҳ��
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "loginApp";
	}
	/**
	 * �����ߵ���
	 * @return
	 */
	@RequestMapping(value="/devuser",method=RequestMethod.GET)
	public String devUser(){
		return "devUser/login";
	}
	/**
	 * �����ߵ�¼��ѯ
	 * @param devCode
	 * @param devPassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/devuserSave",method=RequestMethod.POST)
	public String devUserSave(DevUser user, Model model){
		log.info("����devUserSave����,�˺�Ϊ:"+user);
		String error = "";
		Integer result = userService.getDevUserLogin(user);
		log.info("�˺�����Ϊresult=======>"+result);
		if(result != null){
			return "index";
		}else {
			error = "�û������������,����������!";
			model.addAttribute("error", error);
			return "devUser/login";
		}
	}
	/**
	 * ����Ա����
	 * @return
	 */
	@RequestMapping(value="/backenduser",method=RequestMethod.GET)
	public String backendUser(){
		return "backendUser/login";
	}
	/**
	 * ����Ա��¼�ж�
	 * @param userCode
	 * @param userPassword
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/backendUserSave",method=RequestMethod.POST)
	public String backendUserSave(BackendUser user , Model model){
		log.info("����backendUserSave����,�˺�Ϊ:"+user);
		String error = "";
		Integer result = backendUserService.getBacUserLogin(user);
		log.info("�˺�����Ϊresult=======>"+result);
		if(result != null){
			return "index";
		}else {
			error = "�û������������,����������!";
			model.addAttribute("error", error);
			return "backendUser/login";
		}
	}
}
