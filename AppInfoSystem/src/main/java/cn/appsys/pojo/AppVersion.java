package cn.appsys.pojo;

import java.util.Date;
/**
 * app版本信息
 * @author ldj
 *
 */
public class AppVersion {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * appid
	 */
	private Integer appId;
	/**
	 * 版本�?
	 */
	private String versionNo;
	/**
	 * 版本信息
	 */
	private String versionInfo;
	/**
	 * 发布状�??
	 */
	private Integer publishStatus;
	/**
	 * 下载链接
	 */
	private String downloadLink;
	/**
	 * 版本大小
	 */
	private Double versionSize;
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
	/**
	 * APK路径
	 */
	private String apkLocPath;
	/**
	 * APK文件名称
	 */
	private String apkFileName;
	
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
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public String getVersionInfo() {
		return versionInfo;
	}
	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}
	public Integer getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}
	public String getDownloadLink() {
		return downloadLink;
	}
	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}
	public Double getVersionSize() {
		return versionSize;
	}
	public void setVersionSize(Double versionSize) {
		this.versionSize = versionSize;
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
	public String getApkLocPath() {
		return apkLocPath;
	}
	public void setApkLocPath(String apkLocPath) {
		this.apkLocPath = apkLocPath;
	}
	public String getApkFileName() {
		return apkFileName;
	}
	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}
	

}
