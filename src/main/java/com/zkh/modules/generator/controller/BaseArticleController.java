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
import com.zkh.modules.generator.entity.BaseArticleEntity;
import com.zkh.modules.generator.service.BaseArticleService;


/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
@RestController
@RequestMapping("basearticle")
public class BaseArticleController {
	@Autowired
	private BaseArticleService baseArticleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("basearticle:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BaseArticleEntity> baseArticleList = baseArticleService.queryList(query);
		int total = baseArticleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(baseArticleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("basearticle:info")
	public R info(@PathVariable("id") Integer id){
		BaseArticleEntity baseArticle = baseArticleService.queryObject(id);
		
		return R.ok().put("baseArticle", baseArticle);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("basearticle:save")
	public R save(@RequestBody BaseArticleEntity baseArticle){
		baseArticleService.save(baseArticle);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("basearticle:update")
	public R update(@RequestBody BaseArticleEntity baseArticle){
		baseArticleService.update(baseArticle);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("basearticle:delete")
	public R delete(@RequestBody Integer[] ids){
		baseArticleService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
