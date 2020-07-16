package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.CardHolder;
import com.emsystem.pojo.CardHolderClass;
import com.emsystem.pojo.File;


public interface CardHolderDao {
	
	
	
	@Select("select * from name_card_class")
	@ResultType(CardHolderClass.class)
	List<CardHolderClass> queryCardClass();
	

	@Select("select * from name_card")
	@ResultType(CardHolder.class)
	List<CardHolder> queryAllName_card();
	
	@Select("select * from name_card where user_name like CONCAT('%',#{key1},'%')  and  department_name like CONCAT('%',#{key2},'%')" )
	@ResultType(CardHolder.class)
	List<CardHolder> queryName_cardByKeyWord(@Param("key1")String key1,@Param("key2")String key2);
	
	@Select("select * from name_card where user_name like CONCAT('%',#{key},'%')")
	@ResultType(CardHolder.class)
	List<CardHolder> queryName_cardByKeyWord1(String key);
	
	@Select("select * from name_card where department_name like CONCAT('%',#{key},'%')")
	@ResultType(CardHolder.class)
	List<CardHolder> queryName_cardByKeyWord2(String key);
	
	@Insert("insert into name_card(user_name,department_name,contact,post) values(#{user_name},#{department_name},#{contact},#{post})")
	public int addCard(CardHolder card) throws SQLException;

	@Insert("insert into name_card_class(name_cardid,card_name) values(#{name_cardid},#{card_name})")
	public int addCardClass(CardHolderClass card) throws SQLException;


}
