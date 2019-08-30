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
public class appInfoController {
	
	private Logger log = Logger.getLogger(appInfoController.class);
	
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataService;
	@Resource
	private AppCategoryService cateService;
	
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
	
	@RequestMapping(value="/appInfo")
	public String apptest1(Model model,
			@RequestParam(value = "softwareName", required = false, defaultValue = "") String softwareName,
			@RequestParam(value = "appStatus",required = false,defaultValue = "") String appStatus,
			@RequestParam(value = "appFlatform",required = false,defaultValue = "") String appFlatform,
			@RequestParam(value = "appCategoryName1",required = false,defaultValue = "") String appCategoryName1,
			@RequestParam(value = "appCategoryName2",required = false,defaultValue = "") String appCategoryName2,
			@RequestParam(value = "appCategoryName3",required = false,defaultValue = "") String appCategoryName3){
		AppInfo appInfo = new AppInfo();
		appInfo.setSoftwareName(softwareName);
		Integer status = null;
		if(appStatus!=null && !appStatus.equals("")){
			status = Integer.parseInt(appStatus);
		}
		Integer flat = null;
		if(appFlatform!=null && !appFlatform.equals("")){
			flat = Integer.parseInt(appFlatform);
		}
		Integer cate1 = null;
		if(appCategoryName1!=null && !appCategoryName1.equals("")){
			cate1 = Integer.parseInt(appCategoryName1);
		}
		Integer cate2 = null;
		if(appCategoryName2!=null && !appCategoryName2.equals("")){
			cate2 = Integer.parseInt(appCategoryName2);
		}
		Integer cate3 = null;
		if(appCategoryName3!=null && !appCategoryName3.equals("")){
			cate3 = Integer.parseInt(appCategoryName3);
		}
		appInfo.setStatus(status);
		appInfo.setFlatformId(flat);
		appInfo.setCategoryLevel1(cate1);
		appInfo.setCategoryLevel2(cate2);
		appInfo.setCategoryLevel3(cate3);
		List<AppInfo> appList = appInfoService.getAppInfoList(appInfo);
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		List<AppCategory> categoryLevel1List = null;//列出一级分类列表，注：二级和三级分类列表通过异步ajax获取
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
