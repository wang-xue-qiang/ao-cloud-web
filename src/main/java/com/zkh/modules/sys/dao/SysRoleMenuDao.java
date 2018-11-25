package com.zkh.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.sys.entity.SysRoleMenuEntity;

/**
 * 角色与菜单对应关系
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2016年9月18日 上午9:33:46
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
}
