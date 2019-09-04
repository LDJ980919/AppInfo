package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * 查询所有App基础信息,可根据软件名称模糊查询,状态,平台,一级二级三级分来查询
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(AppInfo appInfo);
	/**
	 * 增加APP基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer addAppInfo(AppInfo appInfo);
	/**
	 * 更改APP基础信息
	 * @param appInfo
	 * @return
	 */
	public Integer updateAppInfo(AppInfo appInfo);
	/**
	 * 删除app基础信息
	 * @param id
	 * @return
	 */
	public Integer deleteAppInfo(Integer id);
	/**
	 * 根据id获取apk名称
	 * @param id
	 * @return
	 */

	public AppInfo getAppInfo(Integer id);


	
	/**
	 * 根据id查询app基础信息
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(Integer id);
	/**
	 * 根据id来修改appinfo的版本信息
	 */
	public Integer updateAppVersion(AppInfo appInfo);
	/**
	 * 改变app的状态
	 */
	public Integer upAndDown(AppInfo appInfo);

}
