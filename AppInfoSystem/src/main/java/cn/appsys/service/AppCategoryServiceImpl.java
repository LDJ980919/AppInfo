package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.AppCategoryMapper;
import cn.appsys.pojo.AppCategory;
@Service("appCategoryService")
@Transactional
public class AppCategoryServiceImpl implements AppCategoryMapper {
	@Resource
	private AppCategoryMapper appCategoryMapper;
	public List<AppCategory> getAppCategory(Integer type) {
	
		return appCategoryMapper.getAppCategory(type);
	}

}
