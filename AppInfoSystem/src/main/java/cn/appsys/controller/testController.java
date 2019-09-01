package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.AppInfo;
import cn.appsys.service.AppInfoService;

@Controller
public class testController {
	
	@Resource
	private AppInfoService appService;
	
	@RequestMapping(value="/checkAppInfo")
	public String test(Model model){
		AppInfo appInfo = new AppInfo();
		appInfo = appService.getAppInfoById(2);
		model.addAttribute("appInfo", appInfo);
		return "appInfo/checkAppInfo";
	}
}
