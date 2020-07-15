package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emsystem.dao.BoardroomDao;
import com.emsystem.pojo.Boardroom;
import com.emsystem.service.BoardroomService;
import com.emsystem.service.UserLoginService;

public class BoardroomServiceImpl implements BoardroomService{
	@Autowired
	private BoardroomDao dao;
	//查询所有订单
		@Override
		public List<Boardroom> selectAll() {
			// TODO Auto-generated method stub
			return dao.selectAll();
		}
}
