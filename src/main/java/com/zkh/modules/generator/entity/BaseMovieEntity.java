package com.zkh.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author admin
 * @email admin@qq.com
 * @date 2017-11-14 13:52:03
 */
public class BaseMovieEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//标题
	private String title;
	//描述
	private String description;
	//标签
	private Integer tag;
	//类型
	private Integer type;
	//链接
	private String url;
	//创建时间
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：标签
	 */
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	/**
	 * 获取：标签
	 */
	public Integer getTag() {
		return tag;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
