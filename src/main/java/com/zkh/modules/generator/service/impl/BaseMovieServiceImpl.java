package com.zkh.modules.generator.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkh.modules.generator.dao.BaseMovieDao;
import com.zkh.modules.generator.entity.BaseMovieEntity;
import com.zkh.modules.generator.service.BaseMovieService;



@Service("baseMovieService")
public class BaseMovieServiceImpl implements BaseMovieService {
	@Autowired
	private BaseMovieDao baseMovieDao;
	
	@Override
	public BaseMovieEntity queryObject(Integer id){
		return baseMovieDao.queryObject(id);
	}
	
	@Override
	public List<BaseMovieEntity> queryList(Map<String, Object> map){
		return baseMovieDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseMovieDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseMovieEntity baseMovie){
		baseMovieDao.save(baseMovie);
	}
	
	@Override
	public void update(BaseMovieEntity baseMovie){
		baseMovieDao.update(baseMovie);
	}
	
	@Override
	public void delete(Integer id){
		baseMovieDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		baseMovieDao.deleteBatch(ids);
	}
	
}
