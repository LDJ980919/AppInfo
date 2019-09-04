package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.BackendUser;



/**
 * ����Ա�����߼���
 * @author Administrator
 *
 */
@Repository("backendUserMapper")
public interface BackendUserMapper {
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
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public Integer addUser(BackendUser user);
	

}
