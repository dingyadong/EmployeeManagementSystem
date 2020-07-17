package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.UserAddresslist;
/**
 * @通讯录
 * @author jingc
 * @date 2020.7.16
 */

public interface UserAddressService {
	
	// 查询所有
	List<UserAddresslist> queryAll();
	//删除
	int delete(int did);
	

}
