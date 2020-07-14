package com.emSystem.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.emSystem.pojo.Folder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



	@Controller
	public class FolderControoller {
		@Autowired
		
		@RequestMapping("/upload")
		public String upload(){
			
			return "upload";
		}
		
		
		@RequestMapping("/a2")
		public String ajaxtest(){
		List<Folder> userList = new ArrayList<Folder>();
		userList.add(new Folder("妗妗1","1","男"));
		userList.add(new Folder("妗妗12","1","男"));
		userList.add(new Folder("妗妗13","1","男"));
		Folder user4 = new Folder("妗妗14","1","男");
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
