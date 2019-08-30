package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.AppCategory;

public interface AppCategoryService {
	public List<AppCategory> getAppCategory(Integer type);
	public List<AppCategory> getAppCategoryById(Integer id);
	public List<AppCategory> getAppCategoryList();
}
