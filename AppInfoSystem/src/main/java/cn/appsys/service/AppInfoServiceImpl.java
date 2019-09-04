package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.AppInfoMapper;
import cn.appsys.pojo.AppInfo;

@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl implements AppInfoService{
	@Resource
	private AppInfoMapper appInfoMapper;
	
	public List<AppInfo> getAppInfoList(AppInfo appInfo) {
		return appInfoMapper.getAppInfoList(appInfo);
	}

	public Integer addAppInfo(AppInfo appInfo) {
		return appInfoMapper.addAppInfo(appInfo);
	}

	public Integer updateAppInfo(AppInfo appInfo) {
		return appInfoMapper.updateAppInfo(appInfo);
	}

	/**
	 * 根据id获取apk名称
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfo(Integer id) {
		return appInfoMapper.getAppInfo(id);
	}

	

	@Override
	public Integer deleteAppInfo(Integer id) {
		return appInfoMapper.deleteAppInfo(id);
	}

	@Override
	public AppInfo getAppInfoById(Integer id) {
		return appInfoMapper.getAppInfoById(id);
	}

	@Override
	public Integer updateAppVersion(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoMapper.updateAppVersion(appInfo);
	}

	@Override
	public Integer upAndDown(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return appInfoMapper.upAndDown(appInfo);
	}
	

	
}
