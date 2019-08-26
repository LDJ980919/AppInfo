package cn.appsys.pojo;

import java.util.Date;
/**
 * �?发�?�用�?
 * @author ldj
 *
 */
public class dev_user {
	/**
	 * id
	 */
	private int id;
	/**
	 * 编码
	 */
	private String devCode;
	/**
	 * 名称
	 */
	private String devName;
	/**
	 * 密码
	 */
	private String devPassword;
	/**
	 * 电子邮箱
	 */
	private String devEmail;
	/**
	 * �?发信�?
	 */
	private String devInfo;
	/**
	 * 创建�?
	 */
	private int createdBy;
	/**
	 * 创建时间
	 */
	private Date creationDate;
	/**
	 * 更新�?
	 */
	private int modifyBy;
	/**
	 * 更新时间
	 */
	private Date modifyDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDevCode() {
		return devCode;
	}
	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevPassword() {
		return devPassword;
	}
	public void setDevPassword(String devPassword) {
		this.devPassword = devPassword;
	}
	public String getDevEmail() {
		return devEmail;
	}
	public void setDevEmail(String devEmail) {
		this.devEmail = devEmail;
	}
	public String getDevInfo() {
		return devInfo;
	}
	public void setDevInfo(String devInfo) {
		this.devInfo = devInfo;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
