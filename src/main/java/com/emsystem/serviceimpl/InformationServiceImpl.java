package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.InformationDao;
import com.emsystem.pojo.Information;
import com.emsystem.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService {
	@Autowired
	private InformationDao dao;
	
	//查询
	@Override
	public List<Information> queryAll() {
		return dao.queryAll();
	}
}
