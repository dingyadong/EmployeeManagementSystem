package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.emsystem.pojo.Folder;
import com.emsystem.pojo.UserInformation;
public interface FolderDao {
	public  void addFolderInfo(Folder folderInfo) throws SQLException;
	public  List<Folder> ShareFolderList();
	public  List<Folder> FolderList();
	
	@Insert("insert into file(file_name,file_url,file_share) values(#{folderName},#{folderUrl},0)")
	public int addFolderInfo(UserInformation users);
	

}
