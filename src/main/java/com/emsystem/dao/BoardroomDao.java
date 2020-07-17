package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.Boardroom;

/*
 * 会议室管理
 * 编写：蒋旭
 * 2020.7.15
 */
public interface BoardroomDao {
	//查询全部会议室
	@Select("select * from boardroom")
	@ResultType(Boardroom.class)
	public List<Boardroom> boardroomList() throws SQLException;
	//根据id查询会议室
	@Select("select * from boardroom where boradroom_id = #{boardroom_id}")
	@ResultType(Boardroom.class)
	public Boardroom boardroomById(Integer boardroom_id) throws SQLException;
	//删除
	@Delete("delete from boardroom where boardroom_id = #{boardroom_id}")
	public int deleteBoardroomById(Integer boardroom_id);
	//更新
	@Update("update boardroom set is_order = 1 where boardroom_id = #{boardroom_id}")
	public int updateBoardroomById(Integer boardroom_id);
	//查询已被预约的会议室
	@Select("select * from boardroom where is_order=1")
	@ResultType(Boardroom.class)
	public List<Boardroom> OrderdBoardroomList();
	//添加  
	@Insert("insert into boardroom(boardroom_id,boardroom_name,boardroom_url,space,air_condition,is_order,order_name) values(#{boardroom_id},#{boardroom_name},#{boardroom_url},#{space},${air_condition},${is_order},${order_name})")
	public int addBoardroomInfo(Boardroom boardroom) throws SQLException;
	
}
