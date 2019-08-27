package cn.appsys.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.UserMapper;
import cn.appsys.pojo.DevUser;
/**
 * 业务逻辑实现层
 * @author ldj
 *
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	/**
	 * 用户登入
	 * @return
	 */
	public DevUser getUserList(DevUser user) {
		return userMapper.getUserList(user);
	}
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public Integer addUser(DevUser user) {
		return userMapper.addUser(user);
	}
	/**
	 * 用户修改
	 * @param user
	 * @return
	 */
	public Integer updateUser(DevUser user) {
		return userMapper.updateUser(user);
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Integer deleteUser(Integer id) {
		return userMapper.deleteUser(id);
	}

}
