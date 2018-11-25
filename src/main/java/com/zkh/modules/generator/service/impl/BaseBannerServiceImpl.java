package com.zkh.modules.generator.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkh.modules.generator.dao.BaseBannerDao;
import com.zkh.modules.generator.entity.BaseBannerEntity;
import com.zkh.modules.generator.service.BaseBannerService;



@Service("baseBannerService")
public class BaseBannerServiceImpl implements BaseBannerService {
	@Autowired
	private BaseBannerDao baseBannerDao;
	
	@Override
	public BaseBannerEntity queryObject(Integer id){
		return baseBannerDao.queryObject(id);
	}
	
	@Override
	public List<BaseBannerEntity> queryList(Map<String, Object> map){
		return baseBannerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseBannerDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseBannerEntity baseBanner){
		baseBannerDao.save(baseBanner);
	}
	
	@Override
	public void update(BaseBannerEntity baseBanner){
		baseBannerDao.update(baseBanner);
	}
	
	@Override
	public void delete(Integer id){
		baseBannerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		baseBannerDao.deleteBatch(ids);
	}
	
}
