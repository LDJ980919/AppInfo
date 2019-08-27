package cn.appsys.service;
/**
 * 管理员登入实现层
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
	 * 管理员登入
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public Integer getBacUserLogin(BackendUser user) {
		return backendUserMapper.getBacUserLogin(user);
	}
	/**
	 * 修改管理员信息
	 * @param user
	 * @return
	 */
	public Integer updateBacUser(BackendUser user) {
		return backendUserMapper.updateBacUser(user);
	}
	/**
	 * 删除管理员信息
	 * @param id
	 * @return
	 */
	public Integer deleteBacUser(Integer id) {
		return backendUserMapper.deleteBacUser(id);
	}
	/**
	 * 查询所有管理员信息
	 * @param user
	 * @return
	 */
	public List<BackendUser> getBacUserList(BackendUser user) {
		return backendUserMapper.getBacUserList(user);
	}

}
