package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emsystem.dao.FolderDao;
import com.emsystem.pojo.Folder;
import com.emsystem.service.FolderService;

public class FolderServiceImpl implements FolderService{
@Autowired FolderDao dao;
	@Override
	public List<Folder> FolderList() {
		// TODO Auto-generated method stub
		return dao.FolderList();
	}

	@Override
	public List<Folder> ShareFolderList() {
		// TODO Auto-generated method stub
		return dao.ShareFolderList();
	}

}
