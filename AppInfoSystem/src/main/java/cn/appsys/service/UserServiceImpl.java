package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.UserMapper;
import cn.appsys.pojo.DevUser;
/**
 * ҵ���߼�ʵ�ֲ�
 * @author ldj
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	/**
	 * �û�����
	 * @param devCode
	 * @return
	 */
	public Integer getDevUserLogin(DevUser user){
		return userMapper.getDevUserLogin(user);
	}
	/**
	 * ��ѯ�����û�
	 * @return
	 */
	public List<DevUser> getUserList(DevUser user) {
		return userMapper.getUserList(user);
	}
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public Integer addUser(DevUser user) {
		return userMapper.addUser(user);
	}
	/**
	 * �û��޸�
	 * @param user
	 * @return
	 */
	public Integer updateUser(DevUser user) {
		return userMapper.updateUser(user);
	}
	/**
	 * ɾ���û�
	 * @param id
	 * @return
	 */
	public Integer deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

}
