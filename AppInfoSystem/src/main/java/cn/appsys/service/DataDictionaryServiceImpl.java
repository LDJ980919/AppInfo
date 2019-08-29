package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.appsys.dao.DataDictionaryMapper;
import cn.appsys.pojo.DataDictionary;
@Service("dataDictionaryService")
@Transactional
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Resource
	private DataDictionaryMapper dataDictionaryMapper;
	
	public List<DataDictionary> getDataDictionary(DataDictionary dataDictionary) {
		// TODO Auto-generated method stub
		return dataDictionaryMapper.getDataDictionary(dataDictionary);
	}

}
