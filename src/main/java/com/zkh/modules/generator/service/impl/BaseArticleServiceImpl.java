package com.zkh.modules.generator.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkh.modules.generator.dao.BaseArticleDao;
import com.zkh.modules.generator.entity.BaseArticleEntity;
import com.zkh.modules.generator.service.BaseArticleService;



@Service("baseArticleService")
public class BaseArticleServiceImpl implements BaseArticleService {
	@Autowired
	private BaseArticleDao baseArticleDao;
	
	@Override
	public BaseArticleEntity queryObject(Integer id){
		return baseArticleDao.queryObject(id);
	}
	
	@Override
	public List<BaseArticleEntity> queryList(Map<String, Object> map){
		return baseArticleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseArticleDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseArticleEntity baseArticle){
		baseArticleDao.save(baseArticle);
	}
	
	@Override
	public void update(BaseArticleEntity baseArticle){
		baseArticleDao.update(baseArticle);
	}
	
	@Override
	public void delete(Integer id){
		baseArticleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		baseArticleDao.deleteBatch(ids);
	}
	
}
