package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
	@Select("SELECT * from boardroom where 1 = 1")
	@ResultType(Boardroom.class)
	//public
	public List<Boardroom> selectAll();
	//通过序号查询会议室
	@Select("select * from boardroomt where boardroom_name like #{boardroom_name}")
	public Boardroom selectOne(String boardroom_id);
	//新增
	@Insert("insert into boardroom(boardroom_id,boardroom_name,boardroom_url"
			+ ",space,air_condition) values(#{boardroom_id},#{boardroom_name}"
			+ ",#{boardroom_url},#{space},#{air_condition})")
	public int add(Boardroom b);
	//编辑
	@Update("update boardroom set boardroom_name=#{boardroom_name},boardroom_url=#{boardroom_url},"
			+ "space=#{space},air_condition=#{air_condition} where boardroom_id=#{boardroom_id}")
	int update(Boardroom boardroom);
	//根据id删除商品类型
	@Delete("delete from boardroom where boardroom_id=#{boardroom_id}")
	public int delete(@Param("boardroom_id")int deleteb);
}
