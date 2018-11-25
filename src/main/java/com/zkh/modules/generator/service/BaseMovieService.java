package com.zkh.modules.generator.service;

import java.util.List;
import java.util.Map;

import com.zkh.modules.generator.entity.BaseMovieEntity;

/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
public interface BaseMovieService {
	
	BaseMovieEntity queryObject(Integer id);
	
	List<BaseMovieEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseMovieEntity baseMovie);
	
	void update(BaseMovieEntity baseMovie);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
