package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.FileDao;
import com.emsystem.pojo.file;
import com.emsystem.service.FileService;
@Service
public class FileServiceImpl implements FileService{
@Autowired FileDao dao;
	@Override
	public List<file> FileList() {
		// TODO Auto-generated method stub
		return dao.FolderList();
	}

	@Override
	public List<file> ShareFileList() {
		// TODO Auto-generated method stub
		return dao.ShareFolderList();
	}

}
