package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.UserInformationSearchDao;
import com.emsystem.pojo.UserInformation;
import com.emsystem.service.UserInformationSearchService;
@Service
public class UserInformationSearchServiceImpl implements UserInformationSearchService{
	@Autowired
	private UserInformationSearchDao dao;
	@Override
	public List<UserInformation> queryByName(String name) {
		//模糊查询
		return dao.queryName(name);
	}
	

}
