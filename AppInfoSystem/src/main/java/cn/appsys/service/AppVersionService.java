package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	/**
	 * 根据appId查询app信息
	 * @param id
	 * @return
	 */
	public List<AppVersion> getAppVersionListById(Integer appId);
	/**
	 * 添加app版本信息
	 * @param appVersion
	 * @return
	 */
	public Integer addAppVersion(AppVersion appVersion);
	/**
	 * 根据id修改版本信息
	 * @param id
	 * @return
	 */
	public Integer updateAppVersion(Integer id);
	/**
	 * 根据id查询版本信息
	 * @param id
	 * @return
	 */
	public AppVersion getAppVersionById(Integer id);

}
