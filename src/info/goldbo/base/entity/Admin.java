package info.goldbo.base.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * ʵ����-����Ա
 * ==================================
 * @author huangjinbo
 * @email goldbo891218@gmail.com
 * 2012-8-9 ����5:28:05
 * ==================================
 */
@Entity
public class Admin extends BaseEntity {

	private static final long serialVersionUID = -4389296403087029689L;
	
	private String username;// �û���
	private String password;// ����
	private String email;// E-mail
	private String name;// ����
	private String department;// ����
	private Boolean isAccountEnabled;// �˺��Ƿ�����
	private Boolean isAccountLocked;// �˺��Ƿ�����
	private Boolean isAccountExpired;// �˺��Ƿ����
	private Boolean isCredentialsExpired;// ƾ֤�Ƿ����
	private Integer loginFailureCount;// ������¼ʧ�ܵĴ���
	private Date lockedDate;// �˺���������
	private Date loginDate;// ����¼����
	private String loginIp;// ����¼IP
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Boolean getIsAccountEnabled() {
		return isAccountEnabled;
	}
	public void setIsAccountEnabled(Boolean isAccountEnabled) {
		this.isAccountEnabled = isAccountEnabled;
	}
	
	public Boolean getIsAccountLocked() {
		return isAccountLocked;
	}
	public void setIsAccountLocked(Boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}
	
	public Boolean getIsAccountExpired() {
		return isAccountExpired;
	}
	public void setIsAccountExpired(Boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}
	
	public Boolean getIsCredentialsExpired() {
		return isCredentialsExpired;
	}
	public void setIsCredentialsExpired(Boolean isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}
	
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
}
