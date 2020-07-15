package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.UserInformation;
/**
 * 
 * @author 137213582@QQ.com
 *
 */
public interface UserInformationDao {
	//根据用户名模糊查询
	@Select("select * from user where name LIKE CONCAT(CONCAT('%', #{user_name}),'%');")
	@ResultType(UserInformation.class)
	public List<UserInformation> queryName(String name);
	
	//新增
	@Insert("insert into users(user_id,user_name,password,user_sex,user_age,system_role,post,department_name,self,hobbies,telephone) values(#{user_id},#{user_name},#{password},#{user_sex},#{user_age},#{system_role},#{post},#{department_name},#{self},#{hobbies},#{telephone})")
	public int save(UserInformation users);
	
}
