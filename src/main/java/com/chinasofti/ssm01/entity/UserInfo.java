package com.chinasofti.ssm01.entity;

import com.chinasofti.ssm01.util.BaseBean;

public class UserInfo extends BaseBean{
	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userSex;
	private String userName;
	private String userFaceUrl;
	private String userFacePath;
	public String getUserFacePath() {
		return userFacePath;
	}
	public void setUserFacePath(String userFacePath) {
		this.userFacePath = userFacePath;
	}
	public String getUserFaceUrl() {
		return userFaceUrl;
	}
	public void setUserFaceUrl(String userFaceUrl) {
		this.userFaceUrl = userFaceUrl;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userAccount=" + userAccount + ", userPassword=" + userPassword
				+ ", userSex=" + userSex + ", userName=" + userName + "]";
	}
	public UserInfo() {
		super();
	}
	public UserInfo(Integer userId, String userAccount, String userPassword, String userSex, String userName) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userName = userName;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
