package com.emsystem.service;

import java.util.List;
import com.emsystem.pojo.File;

public interface FileService {
	public List<File> FileList();
	public List<File> ShareFileList();
}
