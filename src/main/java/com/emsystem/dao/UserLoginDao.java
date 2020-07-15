package com.emsystem.dao;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.emsystem.pojo.UserLogin;



public class UserLoginDao {
	//登录 用户名或密码都可以使用
	@Select("select * from t_user where flag=2 and (username=#{name} or email=#{email})")
	@ResultType(UserLogin.class)
	public
	UserLogin select(String name) {
		return null;
	}
}
