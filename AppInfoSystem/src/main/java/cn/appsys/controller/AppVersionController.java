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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/sys/appVersion")
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
	@RequestMapping(value="/addAppVersion{appId}",method=RequestMethod.GET)
	public String appVersion( @PathVariable Integer appId, Model model){
		List<AppVersion> appList = appVersionService.getAppVersionListById(appId);
		log.info("====================================================>"+appList);
		model.addAttribute("appId", appId);
		model.addAttribute("appList", appList);
		return "appInfo/appVersion";
	}
	
	@RequestMapping(value="/addAppVersionSave" ,method=RequestMethod.POST)
	@ResponseBody
	public String addAppVersionSave(AppVersion appVersion ,HttpServletRequest request ,HttpSession session , 
			@RequestParam(value="attachs",required=false)MultipartFile[] attachs){
		String errorType="";//���������
		String errorInfo="";//������Ϣ
		boolean isResult=true;//�Ƿ����
		String fileName="";//���ɵ��ļ�����
		String idPicPath="";
		String workPicPath="";
		String savePath=session.getServletContext().getRealPath("static"+File.separator+"uploadfiles");
		File savaFile=new File(savePath);
		if(!savaFile.exists()){
			savaFile.mkdirs();
		}
		log.info("�ļ�����·����"+savePath);
		for(int i=0;i<attachs.length;i++){
			MultipartFile attach=attachs[i];
			if(!attach.isEmpty()){
				if(i==0){
					errorType="uploadiderror";	
				}else{
					errorType="uploadworkerror";	
				}
				//��ȡԭ�ļ���
				String oldName=attach.getOriginalFilename();
				//��ȡԭ��׺
				String oldSuffix=FilenameUtils.getExtension(oldName);
				int fileSize=500000;
				if(attach.getSize()>fileSize){
					errorInfo="�ļ���С���ó���500kb";
					isResult=false;
				}else if(oldSuffix.equalsIgnoreCase("jpg")||oldSuffix.equalsIgnoreCase("png")||oldSuffix.equalsIgnoreCase("jpeg")||oldSuffix.equalsIgnoreCase("pneg")){
					 fileName=System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_persion.jpg";
					File targetFile=new File(savaFile,fileName);
					if(!targetFile.exists()){
						targetFile.mkdirs();
					}
					//��MultipartFile�����е��ļ���д�뵽�ļ���ȥ
						try {
							attach.transferTo(targetFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							errorInfo="�ļ��ϴ�ʧ��";
							isResult=false;
						} catch (IOException e) {
							e.printStackTrace();
							errorInfo="�ļ��ϴ�ʧ��";
							isResult=false;
						}

					if(i==0){
						idPicPath=fileName;
					}else{
						workPicPath=fileName;
					}
					
				}else{
					errorInfo="�ļ���ʽ����Ϊjpg��png��jpeg��pneg";
					isResult=false;
				}
			}
			}
	if(isResult){
		appVersion.setApkFileName(idPicPath);
		appVersion.setCreatedBy(((DevUser)session.getAttribute("user")).getId());
		appVersion.setCreationDate(new Date());
		appVersion.setPublishStatus(11);
		Integer result = appVersionService.addAppVersion(appVersion);
		return JSON.toJSONString(result);
	}else{
		request.setAttribute(errorType, errorInfo);
		return JSON.toJSONString(0);
	}
  }
	@RequestMapping(value="/upAppVersion{appId}",method=RequestMethod.GET)
	public String updateAppVersion(@PathVariable Integer appId , Model model){
		List<AppVersion> appList = appVersionService.getAppVersionListById(appId);
		AppInfo app=appInfoService.getAppInfo(appId);
		model.addAttribute("appId", appId);
		model.addAttribute("appList", appList);
		Integer id=app.getVersionId();
		AppVersion appVersion=null;
		if(id!=null){
		 appVersion = appVersionService.getAppVersionById(id);
		}else{
			appVersion=appList.get(appList.size()-1);
		}
		model.addAttribute("appVersion", appVersion);
		log.info("updateAppVersion方法执行结束,参数为:appVersion"+appVersion);
		return "appInfo/updateAppVersion";
	}
	
	@RequestMapping(value="/updateAppVersionSave" , method=RequestMethod.POST)
	@ResponseBody
	public String updateAppVersionSave(AppVersion appVersion , HttpServletRequest request ,HttpSession session , 
			@RequestParam(value="attachs",required=false)MultipartFile[] attachs){
		log.info("进入updateAppVersionSave方法,参数为appVersion:"+appVersion);
		String errorType="";//���������
		String errorInfo="";//������Ϣ
		boolean isResult=true;//�Ƿ����
		String fileName="";
		String idPicPath="";
		String workPicPath="";
		String savePath=session.getServletContext().getRealPath("static"+File.separator+"uploadfiles");
		File savaFile=new File(savePath);
		if(!savaFile.exists()){
			savaFile.mkdirs();
		}
		log.info("�ļ�����·����"+savePath);
		for(int i=0;i<attachs.length;i++){
			MultipartFile attach=attachs[i];
			if(!attach.isEmpty()){
				if(i==0){
					errorType="uploadiderror";	
				}else{
					errorType="uploadworkerror";	
				}
				//��ȡԭ�ļ���
				String oldName=attach.getOriginalFilename();
				//��ȡԭ��׺
				String oldSuffix=FilenameUtils.getExtension(oldName);
				int fileSize=500000;
				if(attach.getSize()>fileSize){
					errorInfo="�ļ���С���ó���500kb";
					isResult=false;
				}else if(oldSuffix.equalsIgnoreCase("jpg")||oldSuffix.equalsIgnoreCase("png")||oldSuffix.equalsIgnoreCase("jpeg")||oldSuffix.equalsIgnoreCase("pneg")){
					 fileName=System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_persion.jpg";
					File targetFile=new File(savaFile,fileName);
					if(!targetFile.exists()){
						targetFile.mkdirs();
					}
					//��MultipartFile�����е��ļ���д�뵽�ļ���ȥ
						try {
							attach.transferTo(targetFile);
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							errorInfo="�ļ��ϴ�ʧ��";
							isResult=false;
						} catch (IOException e) {
							e.printStackTrace();
							errorInfo="�ļ��ϴ�ʧ��";
							isResult=false;
						}

					if(i==0){
						idPicPath=fileName;
					}else{
						workPicPath=fileName;
					}
					
				}else{
					errorInfo="�ļ���ʽ����Ϊjpg��png��jpeg��pneg";
					isResult=false;
				}
			}
			}
	if(isResult){
		appVersion.setApkFileName(idPicPath);
		appVersion.setModifyBy(((DevUser)session.getAttribute("user")).getId());
		appVersion.setModifyDate(new Date());
		appVersion.setPublishStatus(11);
		Integer result = appVersionService.updateAppVersion(appVersion);
		Integer id1=appVersion.getAppId();
		AppInfo app=appInfoService.getAppInfo(id1);
		app.setId(id1);
		app.setVersionId(appVersion.getId());
		appInfoService.updateAppVersion(app);
		return JSON.toJSONString(result);
	}else{
		request.setAttribute(errorType, errorInfo);
		return JSON.toJSONString(0);
	}
		
	}
	
	
}
