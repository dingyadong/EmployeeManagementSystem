package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.CardHolder;
import com.emsystem.pojo.File;


public interface CardHolderDao {

	//²éÑ¯È«²¿
	@Select("select * from name_card")
	@ResultType(CardHolder.class)
	List<CardHolder> queryAll();
	
	@Insert("insert into name_card(user_name,department_name,contact,post) values(#{user_name},#{department_name},#{contact},#{post})")
	public int addCard(CardHolder card) throws SQLException;

}
