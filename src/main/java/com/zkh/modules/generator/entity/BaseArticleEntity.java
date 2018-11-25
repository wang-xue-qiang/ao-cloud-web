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
public class BaseArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer id;
	//标题
	private String title;
	//描述
	private String description;
	//内容
	private String content;
	//标签
	private Integer tag;
	//类型
	private Integer type;
	//发表人
	private Integer userId;
	//发布状态（1发布0未发布）
	private Integer status;
	//是否置顶（1是0否）
	private Integer isTop;
	//创建时间
	private Date createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
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
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
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
	 * 设置：发表人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：发表人
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：发布状态（1发布0未发布）
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：发布状态（1发布0未发布）
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：是否置顶（1是0否）
	 */
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	/**
	 * 获取：是否置顶（1是0否）
	 */
	public Integer getIsTop() {
		return isTop;
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
