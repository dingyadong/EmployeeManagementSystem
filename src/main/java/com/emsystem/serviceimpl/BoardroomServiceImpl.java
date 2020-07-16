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
		//查询会议室
		@Override
		public Boardroom selectOne(String boardroom_name) {
			// TODO Auto-generated method stub
			return null;
		}
		//添加
		@Override
		public boolean add(Boardroom b) {
			// TODO Auto-generated method stub
			return false;
		}
		//修改
		@Override
		public boolean update(Boardroom boardroom) {
			// TODO Auto-generated method stub
			return false;
		}
		//删除
		@Override
		public int delete(int deleteb) {
			// TODO Auto-generated method stub
			return 0;
		}
}
