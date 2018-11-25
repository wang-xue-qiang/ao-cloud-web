package com.zkh.modules.generator.service;

import java.util.List;
import java.util.Map;

import com.zkh.modules.generator.entity.BaseArticleEntity;

/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
public interface BaseArticleService {
	
	BaseArticleEntity queryObject(Integer id);
	
	List<BaseArticleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseArticleEntity baseArticle);
	
	void update(BaseArticleEntity baseArticle);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
