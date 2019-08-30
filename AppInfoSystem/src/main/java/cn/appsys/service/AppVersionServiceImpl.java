package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {
	@Resource
	private AppVersionMapper appVersionMapper;
	
	/**
	 * 根据appId查询app信息
	 * @param id
	 * @return
	 */
	public List<AppVersion> getAppVersionListById(Integer appId) {
		return appVersionMapper.getAppVersionListById(appId);
	}
	/**
	 * 添加app版本信息
	 * @param appVersion
	 * @return
	 */
	public Integer addAppVersion(AppVersion appVersion) {
		return appVersionMapper.addAppVersion(appVersion);
	}

}
