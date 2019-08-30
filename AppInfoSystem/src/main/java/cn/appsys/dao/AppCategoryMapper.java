package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.AppCategory;

@Repository("appCategoryMapper")
public interface AppCategoryMapper {
public List<AppCategory> getAppCategory(Integer type);
public List<AppCategory> getAppCategoryById(Integer id);
public List<AppCategory> getAppCategoryList();
}
