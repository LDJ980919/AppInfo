package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppInfo;
/**
 * APP��Ϣ�ӿ�
 * @author Administrator
 *
 */
@Repository("appMapper")
public interface AppMapper {
	/**
	 * ����������ѯAPP������Ϣ��
	 * @param appInfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(AppInfo appInfo);
	


}
