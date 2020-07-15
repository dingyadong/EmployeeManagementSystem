package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.Boardroom;
import com.emsystem.pojo.UserLogin;
/*
 * 会议室管理
 * 编写：蒋旭
 * 2020.7.15
 */
public interface BoardroomDao {
	//查询全部会议室
	@Select("SELECT * from boardroom where 1 = 1")
	@ResultType(Boardroom.class)
	//public
	public List<Boardroom> selectAll();
}
