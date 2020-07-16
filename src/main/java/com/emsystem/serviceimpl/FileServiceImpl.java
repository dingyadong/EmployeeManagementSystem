package com.emsystem.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.FileDao;
import com.emsystem.pojo.File;
import com.emsystem.service.FileService;
@Service

public class FileServiceImpl implements FileService{
@Autowired 
FileDao dao;

	@Override
	public List<File> FileList() throws SQLException  {
		// TODO Auto-generated method stub
		return dao.fileList();
	}

	@Override
	public List<File> ShareFileList() {
		// TODO Auto-generated method stub
		return dao.SharefileList();
	}

}
