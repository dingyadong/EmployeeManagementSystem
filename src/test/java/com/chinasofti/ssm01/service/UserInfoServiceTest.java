package com.chinasofti.ssm01.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chinasofti.ssm01.entity.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")
public class UserInfoServiceTest {
	@Autowired
	private UserInfoService userInfoService;
	
	@Test
	public void testLogin(){
		UserInfo userInfo = userInfoService.doLogin(new UserInfo(null, "10001", "abc123", null, null));
		System.out.println(userInfo);
	}
	
	@Test
	public void testList(){
		UserInfo userInfo = new UserInfo();
		userInfo.setStart(2);
		userInfo.setLength(2);
		userInfo.setUserName("уе");
		System.out.println(userInfoService.getUserInfoListCount(userInfo));
		for(UserInfo u : userInfoService.getUserInfoList(userInfo)){
			System.out.println(u);
		}
	}
}
