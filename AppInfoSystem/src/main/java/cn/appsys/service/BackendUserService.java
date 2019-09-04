package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.BackendUser;
/**
 * ����Աҵ���߼���
 * @author ldj
 *
 */
public interface BackendUserService {
	/**
	 * ����Ա����
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser getBacUserLogin(BackendUser user);
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateBacUser(BackendUser user);
	/**
	 * ɾ������Ա��Ϣ
	 * @param id
	 * @return
	 */
	public Integer deleteBacUser(Integer id);
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * @param user
	 * @return
	 */
	public List<BackendUser> getBacUserList(BackendUser user);
	public Integer addUser(BackendUser user);

}
