package cn.appsys.pojo;

import java.util.Date;
/**
 * app基础信息�?
 * @author ldj
 *
 */
public class AppInfo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 软件名字
	 */
	private String softwareName;
	/**
	 * APK名字
	 */
	private String APKName;
	/**
	 * 支持ROM
	 */
	private String supportROM;
	/**
	 * 界面语言
	 */
	private String interfaceLanguage;
	/**
	 * 软件大小
	 */
	private Double softwareSize;
	/**
	 * 更新日期
	 */
	private Date updateDate;
	/**
	 * �?发�?�用户id
	 */
	private Integer devId;
	/**
	 * 基础信息
	 */
	private String appInfo;
	/**
	 * 状�??
	 */
	private Integer status;
	/**
	 * 上架时间
	 */
	private Date onSaleDate;
	/**
	 * 下架时间
	 */
	private Date offSaleDate;
	/**
	 * 平台id
	 */
	private Integer flatformId;
	/**
	 * 种类�?
	 */
	private Integer categoryLevel3;
	/**
	 * 下载
	 */
	private Integer downloads;
	/**
	 * 创建�?
	 */
	private Integer createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 更改�?
	 */
	private Integer modifyBy;
	/**
	 * 更改时间
	 */
	private Date modifyDate;
	/**
	 * 种类�?
	 */
	private Integer categoryLevel1;
	/**
	 * 种类�?
	 */
	private Integer categoryLevel2;
	/**
	 * 标志的图片路�?
	 */
	private String logoPicPath;
	/**
	 * 标志的本地路�?
	 */
	private String logoLocPath;
	/**
	 * 版本id
	 */
	private Integer versionId;
	/**
	 * app查询字典的状态
	 */
	private String appStatus;
	/**
	 * app查询字典的平台
	 */
	private String appFlatform;
	/**
	 * app查询一级分类名称
	 */
	private String appCategoryName1;
	/**
	 * app查询二级分类名称
	 */
	private String appCategoryName2;
	/**
	 * app查询三级分类名称
	 */
	private String appCategoryName3;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public Double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(Double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getDevId() {
		return devId;
	}
	public void setDevId(Integer devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public Integer getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(Integer flatformId) {
		this.flatformId = flatformId;
	}
	public Integer getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(Integer categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public Integer getDownloads() {
		return downloads;
	}
	public void setDownloads(Integer downloads) {
		this.downloads = downloads;
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
	public Integer getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(Integer categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public Integer getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(Integer categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getAppFlatform() {
		return appFlatform;
	}
	public void setAppFlatform(String appFlatform) {
		this.appFlatform = appFlatform;
	}
	public String getAppCategoryName1() {
		return appCategoryName1;
	}
	public void setAppCategoryName1(String appCategoryName1) {
		this.appCategoryName1 = appCategoryName1;
	}
	public String getAppCategoryName2() {
		return appCategoryName2;
	}
	public void setAppCategoryName2(String appCategoryName2) {
		this.appCategoryName2 = appCategoryName2;
	}
	public String getAppCategoryName3() {
		return appCategoryName3;
	}
	public void setAppCategoryName3(String appCategoryName3) {
		this.appCategoryName3 = appCategoryName3;
	}
	
}
