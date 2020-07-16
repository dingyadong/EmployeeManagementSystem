package com.emsystem.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emsystem.dao.FolderDao;
import com.emsystem.pojo.Folder;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.utils.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * 实现功能：个人文件的控制器
 * 分工：丁亚东
 * 日期：2020/7/15
 * 
 */
@Controller
	public class FolderController {
		@Autowired FolderDao folderDao;
		
		@RequestMapping("/upload")
		public String upload(){
			
			return "index";
		}
		
 
		
		@RequestMapping("/doupload")
		public String doUpload(@RequestParam(required=false) MultipartFile mulFile,HttpServletRequest request){
			System.out.println("file name = " + mulFile.getName());
			System.out.println("file real name = " + mulFile.getOriginalFilename());
			String fileUrl = "/upload/" + 
					FileUtil.createRandomFileName() + mulFile.getOriginalFilename();
			fileUrl = request.getServletContext().getRealPath(fileUrl);
			System.out.println("file real url = " + fileUrl);
			
			try {
				FileUtil.copyFileToDisk(fileUrl, mulFile);
				Folder folderInfo = new Folder();
				folderInfo.setFolderName(mulFile.getOriginalFilename());
				folderInfo.setFolderUrl(fileUrl);
				folderDao.addFolderInfo(folderInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "index";
		}
		
		
		@RequestMapping(value = "/insertFile",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson insertFile(Folder folder){
			
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<Folder> userList = new ArrayList<Folder>();
			userList.add(new Folder("妗妗1","2020/07/10 11:05:41","男"));
			userList.add(new Folder("妗妗12","2020/07/10 11:05:41","男"));
			userList.add(new Folder("妗妗13","2020/07/10 11:05:41","男"));
			json.setData(userList);
			System.out.println("OK");
			System.out.println(folder.getFolderName()+folder.getContent());
	        return json;
	    }
		
			
			
		@RequestMapping("/a2")
		@ResponseBody
		public String a2(){
			System.out.println("123");
		List<Folder> userList = new ArrayList<Folder>();
		userList.add(new Folder("妗妗1","1","男"));
		userList.add(new Folder("妗妗12","1","男"));
		userList.add(new Folder("妗妗13","1","男"));
		System.out.println(userList);
		ObjectMapper mapper = new ObjectMapper();

		//将值做为String 写出

		String srt = null;
		try {
			srt = mapper.writeValueAsString(userList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return srt;
		}
		
		@RequestMapping(value = "/folderList",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson testjson(){
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<Folder> userList = new ArrayList<Folder>();
			userList.add(new Folder("妗妗1","2020/07/10 11:05:41","男"));
			userList.add(new Folder("妗妗12","2020/07/10 11:05:41","男"));
			userList.add(new Folder("妗妗13","2020/07/10 11:05:41","男"));
			json.setData(userList);
	        return json;
	    }

		

}
