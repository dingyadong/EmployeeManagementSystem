package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.File;
import com.emsystem.pojo.UserAddresslist;

public interface UserAddresslistDao {
	//查询全部
		@Select("select * from address_list")
		@ResultType(UserAddresslist.class)
		List<UserAddresslist> queryAll();
	/*	//新增
		@Insert("insert into user(user_name) values(#{user_name})")
		public boolean save(UserAddresslist a);*/
		//新增
		@Insert("insert into address_list(user_name,department_name values(#{user_name},#{department_name})")
		public int addfileInfo(File file) throws SQLException;
		//根据id删除商品类型
//		@Delete("delete from user where user_id=#{user_id}")
//		public int delete(@Param("user_id")int did);
		
		@Delete("delete from address_list where addresslist_id = #{addresslist_id}")
		public int delete(Integer addresslist_id);
		

		
}
