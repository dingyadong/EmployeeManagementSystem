package com.emsystem.service;

import com.emsystem.pojo.UserLogin;
/**
 * 
 * @author 137213582@QQ.com
 *
 */
public  interface UserLoginService {

	//根据名称 用户名或者邮箱
	UserLogin getUserByName(String name);
	//查询全部

}
