package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.User;

public interface UserService {
	public List<User> queryAll();

	public User querySingle(int id);

	public boolean save(User u) ;

	public boolean update(User u);

	public int delete(int uid) ;
}
