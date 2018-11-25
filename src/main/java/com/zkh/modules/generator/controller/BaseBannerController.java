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
import com.zkh.modules.generator.entity.BaseBannerEntity;
import com.zkh.modules.generator.service.BaseBannerService;


/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
@RestController
@RequestMapping("basebanner")
public class BaseBannerController {
	@Autowired
	private BaseBannerService baseBannerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("basebanner:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BaseBannerEntity> baseBannerList = baseBannerService.queryList(query);
		int total = baseBannerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(baseBannerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("basebanner:info")
	public R info(@PathVariable("id") Integer id){
		BaseBannerEntity baseBanner = baseBannerService.queryObject(id);
		
		return R.ok().put("baseBanner", baseBanner);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("basebanner:save")
	public R save(@RequestBody BaseBannerEntity baseBanner){
		baseBannerService.save(baseBanner);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("basebanner:update")
	public R update(@RequestBody BaseBannerEntity baseBanner){
		baseBannerService.update(baseBanner);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("basebanner:delete")
	public R delete(@RequestBody Integer[] ids){
		baseBannerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
