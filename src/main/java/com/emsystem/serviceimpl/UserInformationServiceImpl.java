package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.UserInformationDao;
import com.emsystem.pojo.Department;
import com.emsystem.pojo.UserInformation;
import com.emsystem.service.UserInformationService;
@Service
/**
 * 
 * @author 137213582@QQ.com
 *
 */
public class UserInformationServiceImpl implements UserInformationService{
	@Autowired
	private UserInformationDao dao;
	@Override
	public List<UserInformation> queryByName(String name) {
		//模糊查询
		return dao.queryName(name);
	}
	//新增	
	@Override
	public boolean save(UserInformation users) {
		// TODO Auto-generated method stub
		return dao.save(users)>0;
	}
	//查询所有
	@Override
	public List<UserInformation> queryAll() {
		return dao.queryAll();
	}
}
