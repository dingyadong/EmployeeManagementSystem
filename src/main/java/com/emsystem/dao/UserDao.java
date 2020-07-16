package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.User;

public interface UserDao {
	//查询全部
	@Select("select * from user")
	@ResultType(User.class)
	List<User> queryAll();
	//通过id查询单条
	@Select("select * from user where user_id=#{user_id}")
	public User querySingle(int user_id);
	//新增
	@Insert("insert into user(user_name) values(#{user_name})")
	int save(User u);
	//编辑
	@Update("update user set user_name=#{user_name} where user_id=#{user_id}")
	int update(User u);
	//根据id删除
	@Delete("delete from user where user_id=#{user_id}")
	public int delete(@Param("user_id")int did);
	
}
