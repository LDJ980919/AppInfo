package cn.appsys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.appsys.pojo.DataDictionary;

@Repository("dataDictionaryMapper")
public interface DataDictionaryMapper {
	public List<DataDictionary> getDataDictionary(DataDictionary dataDictionary);
}
