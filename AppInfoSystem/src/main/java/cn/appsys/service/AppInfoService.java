package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * �������ģ����ѯ,app״̬��ƽ̨��һ���������ද̬��ѯ
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
}
