package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.Boardroom;

public interface BoardroomService {
	//查询全部会议室
	public List<Boardroom> selectAll();
}
