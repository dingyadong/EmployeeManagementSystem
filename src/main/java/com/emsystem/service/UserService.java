package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.User;

public interface UserService {
	//查询全部
	List<User> queryAll();
	//通过id查询单条
	public User querySingle(int id);
	//新增
	boolean save(User u);
	//编辑类型
	public boolean update(User u);
	//删除
	int delete(int uid);
}
