package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.Department;
import com.emsystem.pojo.UserInformation;

/**
 * 
 * @author 137213582@QQ.com
 *
 */

public  interface UserInformationService {
	//通过名字查询
	List<UserInformation> queryByName(String user_name);
	//新增
	boolean save(UserInformation users);
	//查询所有
	List<UserInformation> queryAll();
}

