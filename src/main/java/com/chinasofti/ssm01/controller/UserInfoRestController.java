package com.chinasofti.ssm01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.ssm01.entity.UserInfo;
import com.google.gson.Gson;

@RestController
@RequestMapping("/user")
public class UserInfoRestController {
	@RequestMapping("/restlogin")
	public UserInfo login0(){
		return new UserInfo(10, "admin", "abc123", "1", "张三") ;
	}
	
	@RequestMapping("/restlogin1")
	public String login1(){
		return new UserInfo(10, "admin", "abc123", "1", "张三").toString();
	}
	
	@RequestMapping("/restlogin2")
	public String login2(){
		return new Gson().toJson(new UserInfo(10, "admin", "abc123", "1", "张三")).toString() ;
	}
}
