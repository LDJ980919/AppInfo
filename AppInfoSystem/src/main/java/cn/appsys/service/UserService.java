package cn.appsys.service;

import cn.appsys.pojo.DevUser;
/**
 * 业务逻辑层
 * @author ldj
 *
 */
public interface UserService {
	/**
	 * 用户登入
	 * @return
	 */
	public DevUser getUserList(DevUser user);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public Integer addUser(DevUser user);
	/**
	 * 用户修改
	 * @param user
	 * @return
	 */
	public Integer updateUser(DevUser user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public Integer deleteUser(Integer id);

}
