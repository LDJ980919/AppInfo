package cn.appsys.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.AppVersionService;
import cn.appsys.service.DataDictionaryService;

@Controller
@RequestMapping("/sys/backendUser")
public class BackendUserController {
private Logger log = Logger.getLogger(BackendUserController.class);
	
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataService;
	@Resource
	private AppCategoryService cateService;
	@Resource
	private AppVersionService appVersionService;
	
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
		List<AppVersion> vlist=appVersionService.getAppVersionList();
		
		DataDictionary dataDictionary = new DataDictionary();
		dataDictionary.setTypeCode("1");
		statusList = dataService.getDataDictionary(dataDictionary);
		dataDictionary.setTypeCode("2");
		flatFormList = dataService.getDataDictionary(dataDictionary);
		categoryLevel1List = cateService.getAppCategory(1);
		categoryLevel2List = cateService.getAppCategory(2);
		categoryLevel3List = cateService.getAppCategory(3);
		
		model.addAttribute("appversion", vlist);
		model.addAttribute("appList", appList);
		model.addAttribute("statusList", statusList);
		model.addAttribute("flatFormList", flatFormList);
		model.addAttribute("categoryLevel1List", categoryLevel1List);
		model.addAttribute("categoryLevel2List", categoryLevel2List);
		model.addAttribute("categoryLevel3List", categoryLevel3List);
		
		return "backendUser/appInfo";
	}
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getIndex(){
		return "backendUser/index";
	}
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	public String logOut(HttpSession session){
		session.removeAttribute("user");
		return "loginApp";
	}
	/**
	 * 审核
	 * @param user
	 * @return
	 */
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	@ResponseBody
	public String userdeleted(Integer id,HttpSession session,Model m){
		AppInfo app=appInfoService.getAppInfo(id);
		Integer versionId=app.getVersionId();
		List<AppVersion> list=appVersionService.getAppVersionListById(id);
		AppVersion appv=appVersionService.getAppVersionById(versionId);
		boolean flag=true;
		for(AppVersion a:list){
			Date d1=appv.getCreationDate();
			Date d2=a.getCreationDate();
			
			if(d2.after(d1)){
				flag=false;
			}
		}
		if(flag){
			return JSON.toJSONString(1);
		}else{
			return JSON.toJSONString(0);
		}
		
	}
	
	@RequestMapping(value="/showApp{id}",method=RequestMethod.GET)
	public String checkAppInfo(@PathVariable Integer id,Model m){
		AppInfo appInfo = appInfoService.getAppInfoById(id);
		m.addAttribute("appInfo", appInfo);
		Integer versionId=appInfo.getVersionId();
		AppVersion appVersion = appVersionService.getAppVersionById(versionId);
		log.info("====================================================>"+appVersion);
		m.addAttribute("appVersion", appVersion);
		return "backendUser/showApp";
	}
	
	@RequestMapping(value="/checkVersion1{id}",method=RequestMethod.GET)
	public String upAndDown(@PathVariable Integer id,Model m){
		AppInfo appInfo=appInfoService.getAppInfo(id);
		Integer status=appInfo.getStatus();
		AppInfo appInfo1=new AppInfo();
		appInfo1.setId(id);
		
			appInfo1.setStatus(2);
		Integer i=appInfoService.upAndDown(appInfo1);
		return "redirect:/sys/backendUser/appInfo";
	}
	@RequestMapping(value="/checkVersion{id}",method=RequestMethod.GET)
	public String upAndDown1(@PathVariable Integer id,Model m){
		AppInfo appInfo=appInfoService.getAppInfo(id);
		Integer status=appInfo.getStatus();
		AppInfo appInfo1=new AppInfo();
		appInfo1.setId(id);
		
			appInfo1.setStatus(3);
		Integer i=appInfoService.upAndDown(appInfo1);
		return "redirect:/sys/backendUser/appInfo";
	}
	
}
