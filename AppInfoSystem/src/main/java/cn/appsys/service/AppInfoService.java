package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppInfo;

public interface AppInfoService {
	/**
	 * 锟斤拷锟斤拷锟斤拷锟侥ｏ拷锟斤拷锟窖�,app状态锟斤拷平台锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟洁动态锟斤拷询
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(AppInfo appInfo);
	/**
	 * 澧炲姞APP鍩虹淇℃伅
	 * @param appInfo
	 * @return
	 */
	public Integer addAppInfo(AppInfo appInfo);
	/**
	 * 鏇存敼APP鍩虹淇℃伅
	 * @param appInfo
	 * @return
	 */
	public Integer updateAppInfo(AppInfo appInfo);
	/**
	 * select
	 */
	public AppInfo getAppInfo(Integer id);
	/**
	 * 鍒犻櫎app鍩虹淇℃伅
	 * @param id
	 * @return
	 */
	public Integer deleteAppInfo(Integer id);
}
