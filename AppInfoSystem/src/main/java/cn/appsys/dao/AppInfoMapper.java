package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.appsys.pojo.AppInfo;
/**
 * APP��Ϣ�б����ݷ��ʲ�ӿ�
 * @author czm
 *
 */
@Repository("appInfoMapper")
public interface AppInfoMapper {
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
	/**
	 * 删除app基础信息
	 * @param id
	 * @return
	 */
	public Integer deleteAppInfo(Integer id);
}
