package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.DevUser;
/**
 * ҵ���߼���
 * @author ldj
 *
 */
public interface UserService {
	/**
	 * �û�����
	 * @param devCode
	 * @return
	 */
	public Integer getDevUserLogin(DevUser user);
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<DevUser> getUserList(DevUser user);
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public Integer addUser(DevUser user);
	/**
	 * �û��޸�
	 * @param user
	 * @return
	 */
	public Integer updateUser(DevUser user);
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public Integer deleteUser(Integer id);
	/**
	 * �����û������û�
	 * @param id
	 * @return
	 */
	public DevUser getUser(DevUser user);

}
