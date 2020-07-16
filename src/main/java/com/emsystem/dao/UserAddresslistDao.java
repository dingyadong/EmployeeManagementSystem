package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.UserAddresslist;

public interface UserAddresslistDao {
	//查询全部
		@Select("select * from user")
		@ResultType(UserAddresslist.class)
		List<UserAddresslist> queryAll();
		//新增
		@Insert("insert into user(user_name) values(#{user_name})")
		public boolean save(UserAddresslist a);
		//编辑
		@Update("update user set user_name=#{user_name} where user_id=#{user_id}")
		public boolean update(UserAddresslist a);
		//根据id删除商品类型
//		@Delete("delete from user where user_id=#{user_id}")
//		public int delete(@Param("user_id")int did);
		
		@Delete("delete from user where user_id = #{user_id}")
		public int delete(Integer user_id);
		
//		@Delete("delete from file where file_id = #{file_id}")
//		public int deleteFileById(Integer file_id);
		
}
