package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.UserInformation;

/**
 * 
 * @author 137213582@QQ.com
 *
 */

public  interface UserInformationSearchService {
	//通过名字查询
	List<UserInformation> queryByName(String name);
}
