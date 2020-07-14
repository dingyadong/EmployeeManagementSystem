package com.chinasofti.ssm01.dao;

import java.util.List;

import com.chinasofti.ssm01.entity.UserInfo;

public interface UserInfoDao {
	public List<UserInfo> getUserInfoList(UserInfo userInfo);
	/**
	 * �������޷�ҳ��ȫ��ѯ
	 * @return
	 */
	public List<UserInfo> getAllUserInfos();
	public void updateUserInfo(UserInfo userInfo);
	public UserInfo getUserInfoByIdAndAccountAndPassword(UserInfo userInfo);
	public void deleteUserInfo(UserInfo userInfo);
	public Long getUserInfoListCount(UserInfo userInfo); 
}
