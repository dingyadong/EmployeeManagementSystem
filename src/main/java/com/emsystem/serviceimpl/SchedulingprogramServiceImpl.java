package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.SchedulingprogramDao;
import com.emsystem.pojo.Schedulingprogram;
import com.emsystem.service.SchedulingprogramService;
@Service

public class SchedulingprogramServiceImpl implements SchedulingprogramService{
	@Autowired
	private SchedulingprogramDao dao;
	//查询
		@Override
		public List<Schedulingprogram> queryAll() {
			return dao.queryAll();
		}

}
