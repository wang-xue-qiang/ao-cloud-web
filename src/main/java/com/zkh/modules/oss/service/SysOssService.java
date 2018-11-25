package com.zkh.modules.oss.service;

import java.util.List;
import java.util.Map;

import com.zkh.modules.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-03-25 12:13:26
 */
public interface SysOssService {
	
	SysOssEntity queryObject(Long id);
	
	List<SysOssEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOssEntity sysOss);
	
	void update(SysOssEntity sysOss);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
