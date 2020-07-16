package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.Schedulingprogram;


public interface SchedulingprogramDao {
	//查询全部
			@Select("select * from scheduling_program")
			@ResultType(Schedulingprogram.class)
			List<Schedulingprogram> queryAll();
}
