package cn.appsys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.DataDictionaryService;

@Controller
@RequestMapping("/sys/devuser")
public class appInfoController {
	
	private Logger log = Logger.getLogger(appInfoController.class);
	
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataService;
	@Resource
	private AppCategoryService cateService;
	
	@RequestMapping(value="/appInfo",method=RequestMethod.GET)
	public String apptest1(@RequestParam(value="categoryLevel1",required=false,defaultValue="")Integer categoryLevel1,
			@RequestParam(value="softwareName",required=false,defaultValue="")String softwareName,
			@RequestParam(value="status",required=false,defaultValue="")Integer status,
			@RequestParam(value="flatformId",required=false,defaultValue="")Integer flatformId,
			@RequestParam(value="categoryLevel2",required=false,defaultValue="")Integer categoryLevel2,
			@RequestParam(value="categoryLevel3",required=false,defaultValue="")Integer categoryLevel3,Model model){
		AppInfo appInfo=new AppInfo();
		appInfo.setSoftwareName(softwareName);
		appInfo.setStatus(status);
		appInfo.setFlatformId(flatformId);
		appInfo.setCategoryLevel1(categoryLevel1);
		appInfo.setCategoryLevel2(categoryLevel2);
		appInfo.setCategoryLevel3(categoryLevel3);
		model.addAttribute("appInfo", appInfo);
		List<AppInfo> appList = appInfoService.getAppInfoList(appInfo);
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;
		List<AppCategory> categoryLevel2List = null;
		List<AppCategory> categoryLevel3List = null;
		
		DataDictionary dataDictionary = new DataDictionary();
		dataDictionary.setTypeCode("1");
		statusList = dataService.getDataDictionary(dataDictionary);
		dataDictionary.setTypeCode("2");
		flatFormList = dataService.getDataDictionary(dataDictionary);
		categoryLevel1List = cateService.getAppCategory(1);
		categoryLevel2List = cateService.getAppCategory(2);
		categoryLevel3List = cateService.getAppCategory(3);
		
		model.addAttribute("appList", appList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("categoryLevel2List", categoryLevel2List);
		model.addAttribute("categoryLevel3List", categoryLevel3List);
		
		return "appInfo/appInfo";
	}
}
