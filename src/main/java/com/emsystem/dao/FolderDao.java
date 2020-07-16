package com.emsystem.dao;

import java.sql.SQLException;
import java.util.List;


import com.emsystem.pojo.Folder;
public interface FolderDao {
	public  void addFolderInfo(Folder folderInfo) throws SQLException;
	public  List<Folder> ShareFolderList();
	public  List<Folder> FolderList();
	
}
