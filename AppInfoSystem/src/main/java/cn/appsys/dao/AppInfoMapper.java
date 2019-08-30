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
	 * 鍒犻櫎app鍩虹淇℃伅
	 * @param id
	 * @return
	 */
	public Integer deleteAppInfo(Integer id);
	/**
	 * 根据id查询该app的信息
	 * @param id
	 * @return
	 */
	public AppInfo getAppInfo(Integer id);
	
}
