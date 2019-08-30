package cn.appsys.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.aspectj.weaver.JoinPointSignature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.AppVersionService;

@Controller
@RequestMapping("/appVersion")
public class AppVersionController {
	
	private Logger log = Logger.getLogger(AppVersionController.class);
	@Resource
	private AppVersionService appVersionService;
	@Resource
	private AppInfoService appInfoService;
	/**
	 * app老版本信息查询
	 * @param appId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addAppVersion")
	public String appVersion( @RequestParam(value="appId")Integer appId , Model model){
		List<AppVersion> appList = appVersionService.getAppVersionListById(appId);
		log.info("====================================================>"+appList);
		model.addAttribute("appList", appList);
		return "/appVersion";
	}
	@RequestMapping(value="/addAppVersionSave" ,method=RequestMethod.POST)
	@ResponseBody
	public String addAppVersionSave(@RequestParam(value="appId")Integer appId  , AppVersion appVersion ,HttpServletRequest request ,HttpSession session , 
			@RequestParam(value="middle-name",required=false)MultipartFile[] attachs){
		String errorInfo="";//错误信息
		boolean isResult = true;//是否出错
		String fileName="";//生成的文件名称
		String errorType = "";//错误的属性
		String savePath = session.getServletContext().getRealPath("statics"+File.separator+"uploadfiles");
		File saveFile = new File(savePath);
		if(saveFile.exists()){
			saveFile.mkdirs();
		}
		log.info("文件保存路劲:"+savePath);
		
		for(int i=0;i<attachs.length;i++){
			log.info("第============"+i+"====================次循环");
			MultipartFile attach = attachs[i];
			if(!attach.isEmpty()){
				//获取原文件名
				String oldName = attach.getOriginalFilename();
				//获取原后缀
				String oldSuffix = FilenameUtils.getExtension(oldName);
				int fileSize = 5000000;
				if(attach.getSize()>fileSize){
					errorInfo = "文件大小不得超过500KB";
					isResult = false;
				}else if(oldSuffix.equalsIgnoreCase("jpg")){
					String apkName = appInfoService.getAppInfo(appId).getAPKName();
					log.info("文件名为:====================>"+apkName);
					fileName = apkName+"-"+appVersion.getVersionNo()+".jpg";
					File targetFile = new File(saveFile , fileName);
					if(!targetFile.exists()){
						targetFile.mkdirs();
					}
					try {
						//将MultipartFile 对象中文件流写入到文件中去
						attach.transferTo(targetFile);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
						errorInfo = "文件上传失败";
						isResult = false;
					}
				}else{
					errorInfo = "文件格式必须为apk";
					isResult = false;
				}
			}
		}
	if(isResult){
		//((User) session.getAttribute("user")).getId();
		DevUser devUser = new DevUser();
		appVersion.setModifyBy(devUser.getId());
		appVersion.setModifyDate(new Date());
		appVersion.setPublishStatus(11);
		Integer result = appVersionService.addAppVersion(appVersion);
		return JSON.toJSONString(result);
	}else{
		request.setAttribute(errorType, errorInfo);
		return JSON.toJSONString(0);
	}
  }
	
	
	
	
	
}
