package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.DataDictionaryService;
import cn.appsys.service.UserService;

@Controller
@RequestMapping("/sys/devuser")
public class DevUserController {
	private Logger log = Logger.getLogger(LoginController.class);
	@Resource
	private UserService userService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getIndex(){
		return "index";
	}
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	public String logOut(HttpSession session){
		session.removeAttribute("user");
		return "loginApp";
	}
	
	@RequestMapping(value="/add")
	public String addApp(Model model){
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setTypeCode("2");
		List<DataDictionary> list=dataDictionaryService.getDataDictionary(dataDictionary);
		model.addAttribute("status", list);
		List<AppCategory> list1=appCategoryService.getAppCategory(1);
		List<AppCategory> list2=appCategoryService.getAppCategory(2);
		List<AppCategory> list3=appCategoryService.getAppCategory(3);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		return "devUser/addApp";
	}
}
