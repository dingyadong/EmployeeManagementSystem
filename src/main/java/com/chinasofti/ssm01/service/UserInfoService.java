package com.chinasofti.ssm01.service;

import java.util.List;

import com.chinasofti.ssm01.entity.UserInfo;

public interface UserInfoService {
	public UserInfo doLogin(UserInfo userInfo);
	public UserInfo getUpdateUserInfoById(UserInfo userInfo);
	public void updateUserInfo(UserInfo userInfo);
	public List<UserInfo> getUserInfoList(UserInfo userInfo);
	public List<UserInfo> getAllUserInfos();
	public void deleteUserInfo(UserInfo userInfo);
	public Long getUserInfoListCount(UserInfo userInfo); 
}
