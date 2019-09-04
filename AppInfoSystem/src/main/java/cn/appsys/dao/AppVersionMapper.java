package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppVersion;
@Repository("appVerviceMapper")
public interface AppVersionMapper {
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
	public Integer updateAppVersion(AppVersion appVersion);
	/**
	 * 根据id查询版本信息
	 * @param id
	 * @return
	 */
	public AppVersion getAppVersionById(Integer id);
	
	public List<AppVersion> getAppVersionList();

}
