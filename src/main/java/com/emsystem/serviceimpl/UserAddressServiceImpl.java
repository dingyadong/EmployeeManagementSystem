package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.UserAddresslistDao;
import com.emsystem.pojo.UserAddresslist;
import com.emsystem.service.UserAddressService;

@Service
public class UserAddressServiceImpl implements UserAddressService {
	@Autowired
	private UserAddresslistDao dao;
	
	//查询
	@Override
	public List<UserAddresslist> queryAll() {
		return dao.queryAll();
	}

	@Override
	public int delete(int did) {
		// TODO Auto-generated method stub
		return dao.delete(did);
//		return 0;
	}
	
	
}
