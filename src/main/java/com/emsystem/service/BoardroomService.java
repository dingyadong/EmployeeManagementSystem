package com.emsystem.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emsystem.pojo.Boardroom;
import com.emsystem.pojo.File;

public interface BoardroomService {
	
	public List<Boardroom> BoardroomList() throws SQLException;
	public List<Boardroom> OrderdBoardroomList();
}
