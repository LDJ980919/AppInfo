package cn.appsys.service;
/**
 * ����Ա����ʵ�ֲ�
 * @author Administrator
 *
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
@Service("backendUserService")
@Transactional
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper backendUserMapper;
	/**
	 * ����Ա����
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser getBacUserLogin(BackendUser user) {
		return backendUserMapper.getBacUserLogin(user);
	}
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param user
	 * @return
	 */
	public Integer updateBacUser(BackendUser user) {
		return backendUserMapper.updateBacUser(user);
	}
	/**
	 * ɾ������Ա��Ϣ
	 * @param id
	 * @return
	 */
	public Integer deleteBacUser(Integer id) {
		return backendUserMapper.deleteBacUser(id);
	}
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * @param user
	 * @return
	 */
	public List<BackendUser> getBacUserList(BackendUser user) {
		return backendUserMapper.getBacUserList(user);
	}
	@Override
	public Integer addUser(BackendUser user) {
		// TODO Auto-generated method stub
		return backendUserMapper.addUser(user);
	}

}
