package com.zkh.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.sys.entity.SysUserRoleEntity;

/**
 * 用户与角色对应关系
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2016年9月18日 上午9:34:46
 */
@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity> {
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
