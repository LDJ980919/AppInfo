package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppInfo;
/**
 * APP信息接口
 * @author Administrator
 *
 */
@Repository("appMapper")
public interface AppMapper {
	/**
	 * 根据条件查询APP基础信息表
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(AppInfo appInfo);
	


}
