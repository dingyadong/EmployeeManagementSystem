package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.Department;
import com.emsystem.pojo.UserInformation;
/**
 * 
 * @author 137213582@QQ.com
 *
 */
public interface UserInformationDao {
	//鏍规嵁鐢ㄦ埛鍚嶆ā绯婃煡璇�
	@Select("select * from user where user_name LIKE CONCAT(CONCAT('%', #{user_name}),'%');")
	@ResultType(UserInformation.class)
	public List<UserInformation> queryName(String user_name);
	
	//鏂板
	@Insert("insert into user(user_id,user_name,password,user_sex,user_age,system_role,post,department_name,self,hobbies,telephone) values(#{user_id},#{user_name},#{password},#{user_sex},#{user_age},#{system_role},#{post},#{department_name},#{self},#{hobbies},#{telephone})")
	public int save(UserInformation users);
	
	//鏌ヨ鎵�鏈�
	//鏌ヨ鍏ㄩ儴
	@Select("select * from user")
	@ResultType(UserInformation.class)
	List<UserInformation> queryAll();
}
