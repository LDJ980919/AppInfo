package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.appsys.pojo.AppInfo;
/**
 * APP锟斤拷息锟叫憋拷锟斤拷锟捷凤拷锟绞诧拷涌锟�
 * @author czm
 *
 */
@Repository("appInfoMapper")
public interface AppInfoMapper {
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
	public AppInfo getAppInfo(Integer id );
	
	/**
	 * 根据id查询app基础信息
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfoById(Integer id);

	
}
