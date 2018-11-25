package com.zkh.modules.oss.dao;


import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.oss.entity.SysOssEntity;
import com.zkh.modules.sys.dao.BaseDao;

/**
 * 文件上传
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-03-25 12:13:26
 */
@Mapper
public interface SysOssDao extends BaseDao<SysOssEntity> {
	
}
