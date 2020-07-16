package com.emsystem.service;

import java.sql.SQLException;
import java.util.List;


import com.emsystem.pojo.File;

public interface FileService {
	public List<File> FileList() throws SQLException;
	public List<File> ShareFileList();
}
