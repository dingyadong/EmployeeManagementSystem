package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.Information;

public interface InformationDao {
	//查询全部
			@Select("select * from information")
			@ResultType(Information.class)
			List<Information> queryAll();
}
