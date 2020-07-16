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

import com.emsystem.dao.FileDao;
import com.emsystem.pojo.File;
import com.emsystem.service.FileService;
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
	public class FileController {
		@Autowired 
		FileDao fileDao;
		@Autowired 
		FileService fileService;
		
		
		@RequestMapping("/upload")
		public String upload(){
			
			return "index";
		}
		
		@RequestMapping(value = "/fileList",produces ={"application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson fileList(){
			System.out.println("OK");
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<File> userList = fileService.FileList();
			json.setData(userList);
	        return json;
	    }
		
		@RequestMapping(value ="/doupload",produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ObjectRlationJson doUpload(@RequestParam(required=false) MultipartFile mulFile,HttpServletRequest request){
			System.out.println("file name = " + mulFile.getName());
			System.out.println("file real name = " + mulFile.getOriginalFilename());
			String fileUrl = "/upload/" + 
					FileUtil.createRandomFileName() + mulFile.getOriginalFilename();
			fileUrl = request.getServletContext().getRealPath(fileUrl);
			System.out.println("file real url = " + fileUrl);
			ObjectRlationJson json = new ObjectRlationJson();
			
			try {
				FileUtil.copyFileToDisk(fileUrl, mulFile);
				File fileInfo = new File();
				fileInfo.setFile_name(mulFile.getOriginalFilename());
				fileInfo.setFile_url(fileUrl);
				fileDao.addfileInfo(fileInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.setMsg("文件传输异常！");
				return json;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				json.setMsg("数据库异常！");
				return json;
			}
			json.setMsg("提交成功！");
			return json;
		}
		
		
		@RequestMapping(value = "/insertFile",produces ={"application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson insertFile(File file){
			
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<File> userList = new ArrayList<File>();

			json.setData(userList);
			System.out.println("OK");
			System.out.println(file.getFile_name()+file.getContent());
	        return json;
	    }
		
			
			
		@RequestMapping("/a2")
		@ResponseBody
		public String a2(){
			System.out.println("123");
		List<File> userList = new ArrayList<File>();

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
		

		

}
