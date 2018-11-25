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
import com.zkh.modules.generator.entity.BaseMovieEntity;
import com.zkh.modules.generator.service.BaseMovieService;


/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
@RestController
@RequestMapping("basemovie")
public class BaseMovieController {
	@Autowired
	private BaseMovieService baseMovieService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("basemovie:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BaseMovieEntity> baseMovieList = baseMovieService.queryList(query);
		int total = baseMovieService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(baseMovieList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("basemovie:info")
	public R info(@PathVariable("id") Integer id){
		BaseMovieEntity baseMovie = baseMovieService.queryObject(id);
		
		return R.ok().put("baseMovie", baseMovie);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("basemovie:save")
	public R save(@RequestBody BaseMovieEntity baseMovie){
		baseMovieService.save(baseMovie);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("basemovie:update")
	public R update(@RequestBody BaseMovieEntity baseMovie){
		baseMovieService.update(baseMovie);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("basemovie:delete")
	public R delete(@RequestBody Integer[] ids){
		baseMovieService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
