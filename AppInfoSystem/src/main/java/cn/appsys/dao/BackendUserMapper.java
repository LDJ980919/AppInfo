package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.BackendUser;

/**
 * 管理员登入逻辑层
 * @author Administrator
 *
 */
@Repository("backendUserMapper")
public interface BackendUserMapper {
	/**
	 * 管理员登入
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public Integer getBacUserLogin(BackendUser user);
	/**
	 * 修改管理员信息
	 * @param user
	 * @return
	 */
	public Integer updateBacUser(BackendUser user);
	/**
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	public Integer deleteBacUser(Integer id);
	/**
	 * 查询所有管理员信息
	 * @param user
	 * @return
	 */
	public List<BackendUser> getBacUserList(BackendUser user);

}
