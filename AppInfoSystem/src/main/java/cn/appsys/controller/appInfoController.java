package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppInfo;
import cn.appsys.service.AppInfoService;

@Controller
public class appInfoController {
	
	private Logger log = Logger.getLogger(appInfoController.class);
	
	@Resource
	private AppInfoService appInfoService;
	
	@RequestMapping(value="/test")
	public String apptest(Model model,
			@RequestParam(value = "softwareName", required = false, defaultValue = "") String softwareName,
			@RequestParam(value = "appStatus",required = false,defaultValue = "") String appStatus){
		AppInfo appInfo = new AppInfo();
		appInfo.setSoftwareName(softwareName);
		appInfo.setAppStatus(appStatus);
		List<AppInfo> appList = appInfoService.getAppInfoList(appInfo);
		model.addAttribute("appList", appList);
		return "appInfo/test";
	}
}
