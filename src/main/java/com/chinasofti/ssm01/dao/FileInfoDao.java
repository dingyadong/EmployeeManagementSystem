package com.chinasofti.ssm01.dao;

import java.sql.SQLException;
import java.util.List;

import com.chinasofti.ssm01.entity.FileInfo;
public interface FileInfoDao {
	public void addFileInfo(FileInfo fileInfo) throws SQLException;
	public List<FileInfo> getFileInfos(FileInfo fileInfo) throws SQLException;
}
