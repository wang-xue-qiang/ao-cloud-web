package com.zkh.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.sys.entity.SysDeptEntity;

/**
 * 部门管理
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-06-20 15:23:47
 */
@Mapper
public interface SysDeptDao extends BaseDao<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);
}
