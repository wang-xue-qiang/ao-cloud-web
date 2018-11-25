package com.zkh.modules.generator.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkh.modules.generator.dao.BaseInfoDao;
import com.zkh.modules.generator.entity.BaseInfoEntity;
import com.zkh.modules.generator.service.BaseInfoService;



@Service("baseInfoService")
public class BaseInfoServiceImpl implements BaseInfoService {
	@Autowired
	private BaseInfoDao baseInfoDao;
	
	@Override
	public BaseInfoEntity queryObject(Integer id){
		return baseInfoDao.queryObject(id);
	}
	
	@Override
	public List<BaseInfoEntity> queryList(Map<String, Object> map){
		return baseInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseInfoEntity baseInfo){
		baseInfoDao.save(baseInfo);
	}
	
	@Override
	public void update(BaseInfoEntity baseInfo){
		baseInfoDao.update(baseInfo);
	}
	
	@Override
	public void delete(Integer id){
		baseInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		baseInfoDao.deleteBatch(ids);
	}
	
}
