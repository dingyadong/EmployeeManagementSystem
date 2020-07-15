package com.emsystem.dao;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.UserLogin;
/**
 * 
 * @author 137213582@QQ.com
 *
 */
public interface UserLoginDao {
	//登录 用户名或密码都可以使用
	@Select("select * from user where system_role=2 and user_name=#{name}")
	@ResultType(UserLogin.class)
	//public
	UserLogin select(String name);
}
