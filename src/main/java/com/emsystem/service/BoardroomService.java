package com.emsystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emsystem.pojo.Boardroom;

public interface BoardroomService {
	//查询全部会议室
	public List<Boardroom> selectAll();
	//通过名称查询
	public Boardroom selectOne(String boardroom_name);
	//增加
	public boolean add(Boardroom b);
	//编辑
	public boolean update(Boardroom boardroom);
	//删除
	public int delete(@Param("boardroom_id")int deleteb);
}
