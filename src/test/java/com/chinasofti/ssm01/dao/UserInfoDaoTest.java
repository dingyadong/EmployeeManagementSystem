package com.chinasofti.ssm01.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasofti.ssm01.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class UserInfoDaoTest {
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Test
	public void testList(){
		UserInfo userInfo = new UserInfo();
		userInfo.setStart(2);
		userInfo.setLength(2);
		userInfo.setUserName("%уе%");
		System.out.println(userInfoDao.getUserInfoListCount(userInfo));
		List<UserInfo> userInfos = userInfoDao.getUserInfoList(userInfo);
		for(UserInfo u : userInfos){
			System.out.println(u.getUserId());
			System.out.println(u.getUserAccount());
		}
	}
	
	@Test
	public void testUpdate(){
		UserInfo userInfo = new UserInfo(1,"10001","abc123","2","уехЩ");
		userInfoDao.updateUserInfo(userInfo);
	}
}
