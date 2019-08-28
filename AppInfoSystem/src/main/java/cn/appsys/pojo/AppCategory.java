package cn.appsys.pojo;

import java.util.Date;
/**
 * 分类
 * @author ldj
 *
 */
public class AppCategory {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 种类编码
	 */
	private String categoryCode;
	/**
	 * 种类名称
	 */
	private String categoryName;
	/**
	 * 父Id
	 */
	private Integer parentId;
	/**
	 *创建�?
	 */
	private Integer createdBy;
	/**
	 * 分类的类型
	 */
	private Integer type;
	
	/**
	 * 创建时间
	 */
	private Date creationTime;
	/**
	 * 更新�?
	 */
	private Integer modifyBy;
	/**
	 * 更新时间
	 */
	private Date modifyDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

}
