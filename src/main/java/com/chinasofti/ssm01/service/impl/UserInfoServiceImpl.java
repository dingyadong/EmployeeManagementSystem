package com.chinasofti.ssm01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.ssm01.dao.UserInfoDao;
import com.chinasofti.ssm01.entity.UserInfo;
import com.chinasofti.ssm01.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	public UserInfo doLogin(UserInfo userInfo) {
		if(userInfo != null && userInfo.getUserAccount() != null && !userInfo.getUserAccount().equals("")
				&& userInfo.getUserAccount() != null && !userInfo.getUserPassword().equals("")){
			UserInfo loginUser = userInfoDao.getUserInfoByIdAndAccountAndPassword(userInfo);
			if(loginUser != null){
				return loginUser;
			}
		}	
		return null;
	}

	public UserInfo getUpdateUserInfoById(UserInfo userInfo) {
		if(userInfo != null && userInfo.getUserId() != null){
			UserInfo updateUser = userInfoDao.getUserInfoByIdAndAccountAndPassword(userInfo);
			if(updateUser != null){
				return updateUser;
			}
		}
		return null;
	}

	public void updateUserInfo(UserInfo userInfo) {
		userInfoDao.updateUserInfo(userInfo);
	}

	public List<UserInfo> getUserInfoList(UserInfo userInfo) {
		if(userInfo != null){
			if(userInfo.getUserName() != null && !userInfo.getUserName().equals("")){
				userInfo.setUserName("%" + userInfo.getUserName() + "%");
			}
			if(userInfo.getUserAccount() != null && !userInfo.getUserAccount().equals("")){
				userInfo.setUserAccount("%" + userInfo.getUserAccount() + "%");
			}
		}
		return userInfoDao.getUserInfoList(userInfo); 
	}

	public void deleteUserInfo(UserInfo userInfo) {
		userInfoDao.deleteUserInfo(userInfo);
	}

	public Long getUserInfoListCount(UserInfo userInfo) {
		if(userInfo != null){
			if(userInfo.getUserName() != null && !userInfo.getUserName().equals("")){
				userInfo.setUserName("%" + userInfo.getUserName() + "%");
			}
			if(userInfo.getUserAccount() != null && !userInfo.getUserAccount().equals("")){
				userInfo.setUserAccount("%" + userInfo.getUserAccount() + "%");
			}
		} 
		return userInfoDao.getUserInfoListCount(userInfo);
	}

	@Override
	public List<UserInfo> getAllUserInfos() {
		return userInfoDao.getAllUserInfos();
	}
	
}
