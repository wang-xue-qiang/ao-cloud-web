package com.zkh.modules.generator.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zkh.common.utils.PageUtils;
import com.zkh.common.utils.Query;
import com.zkh.common.utils.R;
import com.zkh.modules.generator.entity.BaseInfoEntity;
import com.zkh.modules.generator.service.BaseInfoService;
/*import com.zkh.modules.generator.utils.PageUtils;
import com.zkh.modules.generator.utils.Query;
import com.zkh.modules.generator.utils.R;*/


/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-11 18:03:02
 */
@RestController
@RequestMapping("baseinfo")
public class BaseInfoController {
	@Autowired
	private BaseInfoService baseInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("baseinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BaseInfoEntity> baseInfoList = baseInfoService.queryList(query);
		int total = baseInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(baseInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("baseinfo:info")
	public R info(@PathVariable("id") Integer id){
		BaseInfoEntity baseInfo = baseInfoService.queryObject(id);
		
		return R.ok().put("baseInfo", baseInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("baseinfo:save")
	public R save(@RequestBody BaseInfoEntity baseInfo){
		baseInfoService.save(baseInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("baseinfo:update")
	public R update(@RequestBody BaseInfoEntity baseInfo){
		baseInfoService.update(baseInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("baseinfo:delete")
	public R delete(@RequestBody Integer[] ids){
		baseInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
