package cn.appsys.service;

import cn.appsys.pojo.DevUser;
/**
 * ҵ���߼���
 * @author ldj
 *
 */
public interface UserService {
	/**
	 * �û�����
	 * @return
	 */
	public DevUser getUserList(DevUser user);
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

}
