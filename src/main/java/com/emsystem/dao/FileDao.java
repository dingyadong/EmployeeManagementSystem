package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.emsystem.pojo.file;
import com.emsystem.pojo.UserInformation;
public interface FileDao {
	public  void addFolderInfo(file folderInfo) throws SQLException;

	
	@Select("select * from file")
	@ResultType(file.class)
	public List<file> FolderList();
	
	@Select("select * from file where file_share=1")
	@ResultType(file.class)
	public List<file> ShareFolderList();
	
	@Insert("insert into file(file_name,file_url,file_share) values(#{folderName},#{folderUrl},0)")
	public int addFolderInfo(UserInformation users);
	

}
