package com.emsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.dao.FileDao;
import com.emsystem.pojo.File;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.FileService;
/*
 * 实现功能：共享文件夹的控制器
 * 分工：丁亚东
 * 日期：2020/7/15
 * 
 */
@Controller
public class ShareFolderController {
	@Autowired 
	FileDao fileDao;
	@Autowired 
	FileService fileService;
	
	@RequestMapping(value = "/shareFileList",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson shareFileList(){
		ObjectRlationJson json = new ObjectRlationJson();
		
		List<File> List = fileService.ShareFileList();
		json.setData(List);
        return json;
    }
	
	@RequestMapping(value = "/shareFileById",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson shareFileById(File fileInfo){
		ObjectRlationJson json = new ObjectRlationJson();
		int upNum = fileDao.updateFileById(fileInfo.getFile_id());
		if(upNum!=0){
			json.setMsg("共享成功！");
		}else {
			json.setMsg("共享失败！");
		}
	
        return json;
    }
	
}
