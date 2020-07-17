package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.User;

public interface UserService {
	//查询全部
	public List<User> queryAll();
	//查询单条
	public User querySingle(int id);
	//添加
	public boolean save(User u) ;
	//更新
	public boolean update(User u);
	//删除
	public int delete(int uid) ;
}
