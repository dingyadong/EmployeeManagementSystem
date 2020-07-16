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
	//通过id查询类型
	public UserAddresslist querySingle(int id);
	//新增
	public boolean save(UserAddresslist a);
	//编辑类型
	public boolean update(UserAddresslist a);
	//删除
	int delete(int did);
}
