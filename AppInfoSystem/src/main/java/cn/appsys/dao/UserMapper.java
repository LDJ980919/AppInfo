                                                                                                                                                                                                                                                                                                                                               package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.DevUser;
/**
 * 用户操作接口
 * @author ldj
 *
 */
@Repository("userMapper")
public interface UserMapper {
	/**
	 * 用户登入
	 * @param devCode
	 * @return
	 */
	public Integer getDevUserLogin(DevUser user);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<DevUser> getUserList(DevUser user);
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
	/**
	 * 根据用户名查用户
	 * @param id
	 * @return
	 */
	public DevUser getUser(DevUser user);
	

}
