package com.emsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.UserLoginDao;
import com.emsystem.pojo.UserLogin;
import com.emsystem.service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService{
	@Autowired
	private UserLoginDao dao;
	@Override
	public UserLogin getUserByName(String name) {
		// TODO Auto-generated method stub
		return dao.select(name);
	}
	

}
