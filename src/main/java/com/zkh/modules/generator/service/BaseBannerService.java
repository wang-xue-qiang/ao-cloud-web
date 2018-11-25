package com.zkh.modules.generator.service;

import java.util.List;
import java.util.Map;

import com.zkh.modules.generator.entity.BaseBannerEntity;

/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
public interface BaseBannerService {
	
	BaseBannerEntity queryObject(Integer id);
	
	List<BaseBannerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BaseBannerEntity baseBanner);
	
	void update(BaseBannerEntity baseBanner);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
