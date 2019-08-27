package cn.appsys.pojo;

import java.util.Date;
/**
 * 版本更新
 * @author ldj
 *
 */
public class AdPromotion {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * appId
	 */
	private Integer appId;
	/**
	 * 提升图片路径
	 */
	private String adPicPath;
	/**
	 * 页面浏览�?
	 */
	private Integer adPV;
	/**
	 * 旋转定位
	 */
	private Integer carouselPosition;
	/**
	 * �?始时�?
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 创建�?
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
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
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAdPicPath() {
		return adPicPath;
	}
	public void setAdPicPath(String adPicPath) {
		this.adPicPath = adPicPath;
	}
	public Integer getAdPV() {
		return adPV;
	}
	public void setAdPV(Integer adPV) {
		this.adPV = adPV;
	}
	public Integer getCarouselPosition() {
		return carouselPosition;
	}
	public void setCarouselPosition(Integer carouselPosition) {
		this.carouselPosition = carouselPosition;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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
	

}
