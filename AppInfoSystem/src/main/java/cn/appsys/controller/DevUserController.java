package cn.appsys.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.pojo.DataDictionary;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.AppCategoryService;
import cn.appsys.service.AppInfoService;
import cn.appsys.service.AppVersionService;
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
	@Resource
	private AppVersionService appVersionService;
	
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
		
		List<AppCategory> list3=appCategoryService.getAppCategory(3);
		model.addAttribute("list1", list1);
		
		model.addAttribute("list3", list3);
		return "devUser/addApp";
	}
	/**
	 * ��������
	 * @param cid1
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ajaxFindSecondType")
	public @ResponseBody Map<String,Object> findSecondTypeById(String val,HttpServletResponse response )throws Exception{
		Integer a=Integer.parseInt(val);
		List<AppCategory> list2=appCategoryService.getAppCategoryById(a);
		 Map<String,Object> jsonMap=new HashMap<String,Object>();
		 List<Object> list=null;
		 if(null!=list2&&list2.size()>0){
			 list=new ArrayList<Object>();
			 for(AppCategory ac:list2){
			Map<String,String> taskMap=new HashMap<String,String>();
				String s=ac.getId()+"";
				taskMap.put("id",s );
				taskMap.put("name", ac.getCategoryName());
				list.add(taskMap);
				  
			 }
			 jsonMap.put("tasks", list);
		 }
		 return jsonMap;
		 
	}
	
	
	/**
	 * ��ת���û�����
	 * @return
	 */
	@RequestMapping(value="/appInfoAddSave",method=RequestMethod.POST)
	@ResponseBody
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
			
			appInfo.setLogoPicPath(idPicPath);
			
			appInfo.setCreatedBy(((DevUser)session.getAttribute("user")).getId());
			appInfo.setCreationDate(new Date());
			Integer result=appInfoService.addAppInfo(appInfo);
			
			return JSON.toJSONString(result);
			
		}else{
			request.setAttribute("errorType", errorType);
			return JSON.toJSONString(0);
		}
		
		
		
	}
	
	@RequestMapping(value="/panduandApp",method=RequestMethod.POST)
	@ResponseBody
	public String panduandApp(Integer id,HttpSession session,Model m){
		AppInfo appInfo=appInfoService.getAppInfo(id);
		Integer status=appInfo.getStatus();
		return JSON.toJSONString(status);
	}
	
	/**
	 * �޸Ĺ���
	 * @param user
	 * @return
	 */
	
	@RequestMapping(value="/updateApp{id}",method=RequestMethod.GET)
	public String userUpd(@PathVariable String id,HttpSession session,Model m){
		int id1=Integer.parseInt(id);
		log.info("����userupdate����"+id);
		AppInfo appInfo=appInfoService.getAppInfo(id1);
		Integer sta=appInfo.getStatus();
		m.addAttribute("appInfo", appInfo);
		m.addAttribute("sta", sta);
		
		
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setTypeCode("2");
		List<DataDictionary> list=dataDictionaryService.getDataDictionary(dataDictionary);
		m.addAttribute("status", list);
		List<AppCategory> list4=appCategoryService.getAppCategory(1);
		
		
		m.addAttribute("list1", list4);
		
	
		
		List<AppCategory> list1=appCategoryService.getAppCategoryList();
		m.addAttribute("categoryList", list1);
		return "devUser/updateApp";
		
	}
	
	/**
	 * �޸Ĺ���
	 */
		@RequestMapping(value="/appInfoUpdateSave",method=RequestMethod.POST)
		@ResponseBody
		public String appUpdateSave(AppInfo appInfo,HttpServletRequest request,HttpSession session
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
				
				appInfo.setLogoPicPath(idPicPath);
				appInfo.setModifyBy(((DevUser)session.getAttribute("user")).getId());
				appInfo.setModifyDate(new Date());
				Integer result=appInfoService.updateAppInfo(appInfo);
				return JSON.toJSONString(result);
				
			}else{
				request.setAttribute("errorType", errorType);
				return JSON.toJSONString(0);
			}
			
			
			
		}
		/**
		 * 删除
		 * @param user
		 * @return
		 */
		
		@RequestMapping(value="/deletedApp",method=RequestMethod.POST)
		@ResponseBody
		public String userdeleted(Integer id,HttpSession session,Model m){
			
			Integer result=appInfoService.deleteAppInfo(id);
			return JSON.toJSONString(result);
		}
		
		/**
		 * 
		 */
		@RequestMapping(value="/showApp{id}",method=RequestMethod.GET)
		public String checkAppInfo(@PathVariable Integer id,Model m){
			AppInfo appInfo = appInfoService.getAppInfoById(id);
			m.addAttribute("appInfo", appInfo);
			List<AppVersion> appList = appVersionService.getAppVersionListById(id);
			log.info("====================================================>"+appList);
			m.addAttribute("appList", appList);
			return "appInfo/showApp";
		}
		
		@RequestMapping(value="/upAndDown{id}",method=RequestMethod.GET)
		public String upAndDown(@PathVariable Integer id,Model m){
			AppInfo appInfo=appInfoService.getAppInfo(id);
			Integer status=appInfo.getStatus();
			AppInfo appInfo1=new AppInfo();
			appInfo1.setId(id);
			if(status==4){
				appInfo1.setStatus(5);
			}
			if(status==2 ||status==5){
				appInfo1.setStatus(4);
				
			}
			Integer i=appInfoService.upAndDown(appInfo1);
			return "redirect:/sys/devuser/appInfo";
		}
	}

