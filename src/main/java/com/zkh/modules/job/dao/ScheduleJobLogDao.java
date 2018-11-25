package com.zkh.modules.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zkh.modules.job.entity.ScheduleJobLogEntity;
import com.zkh.modules.sys.dao.BaseDao;

/**
 * 定时任务日志
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
