package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
@Service("appCategoryService")
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
	@Resource
	private AppCategoryMapper appCategoryMapper;
	public List<AppCategory> getAppCategory(Integer type) {
	
		return appCategoryMapper.getAppCategory(type);
	}
	public List<AppCategory> getAppCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return appCategoryMapper.getAppCategoryById(id);
	}
	public List<AppCategory> getAppCategoryList() {
		// TODO Auto-generated method stub
		return appCategoryMapper.getAppCategoryList();
	}

}
