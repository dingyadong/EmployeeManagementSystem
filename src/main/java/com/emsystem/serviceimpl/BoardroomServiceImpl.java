package com.emsystem.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.BoardroomDao;
import com.emsystem.dao.FileDao;
import com.emsystem.pojo.Boardroom;
import com.emsystem.pojo.File;
import com.emsystem.service.BoardroomService;
import com.emsystem.service.UserLoginService;
@Service

public class BoardroomServiceImpl implements BoardroomService{
	@Autowired

	BoardroomDao dao;

	
		@Override
		public List<Boardroom> BoardroomList() throws SQLException {
			// TODO Auto-generated method stub
			return dao.boardroomList();
		}

		@Override
		public List<Boardroom> OrderdBoardroomList() {
			// TODO Auto-generated method stub
			return dao.OrderdBoardroomList();
		}
		
}
