package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.UserDao;
import com.emsystem.pojo.User;
import com.emsystem.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

	@Override
	public User querySingle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(User u) {
		// TODO Auto-generated method stub
		return dao.save(u)>0;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int delete(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
