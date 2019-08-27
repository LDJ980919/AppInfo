package cn.appsys.dao;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.DevUser;
/**
 * �û������ӿ�
 * @author ldj
 *
 */
@Repository("userMapper")
public interface UserMapper {
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
