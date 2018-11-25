package com.zkh.modules.generator.service;

import java.util.List;
import java.util.Map;

import com.zkh.modules.generator.entity.BaseInfoEntity;

/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-11 18:03:02
 */
public interface BaseInfoService {
	
	BaseInfoEntity queryObject(Integer id);
	
	List<BaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseInfoEntity baseInfo);
	
	void update(BaseInfoEntity baseInfo);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
