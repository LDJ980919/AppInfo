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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
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
	@Resource
	private AppInfoService appInfoService;
	
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
	public String addApp(@ModelAttribute("appInfo")AppInfo appInfo,Model model){
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
	
	/**
	 * ��ת���û�����
	 * @return
	 */
	@RequestMapping(value="/appInfoAddSave",method=RequestMethod.POST)
	public String userAddSave(AppInfo appInfo,HttpServletRequest request,HttpSession session
			,@RequestParam(value="attachs",required=false)MultipartFile[] attachs ){
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
			appInfo.setLogoLocPath(idPicPath);
			
			
			appInfo.setCreatedBy(((DevUser)session.getAttribute("user")).getId());
			appInfo.setCreationDate(new Date());
			Integer result=appInfoService.addAppInfo(appInfo);
			
			if(result==1){
				return "redirect:/sys/devuser/index";
			}else{
				return "devUser/addApp";
			}
			
		}else{
			request.setAttribute("errorType", errorType);
			return "devUser/addApp";
		}
		
		
		
	}
}
