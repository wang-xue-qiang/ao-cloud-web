package com.zkh.modules.generator.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.generator.entity.BaseMovieEntity;
import com.zkh.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
@Mapper
public interface BaseMovieDao extends BaseDao<BaseMovieEntity> {
	
}
