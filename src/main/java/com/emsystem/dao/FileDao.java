package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.File;
public interface FileDao {


	
	@Select("select * from file")
	@ResultType(File.class)
	public List<File> fileList();
	
	@Select("select * from file where file_share=1")
	@ResultType(File.class)
	public List<File> SharefileList();
	
	@Insert("insert into file(file_name,file_url,file_share) values(#{file_name},#{file_url},0)")
	public int addfileInfo(File file) throws SQLException;
	

}
