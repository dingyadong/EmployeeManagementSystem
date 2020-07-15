package com.emsystem.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Folder;
import com.emsystem.pojo.ObjectRlationJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
	public class FolderControoller {
		
		
		@RequestMapping("/upload")
		public String upload(){
			
			return "index";
		}
		
		
		@RequestMapping("/a2")
		@ResponseBody
		public String a2(){
			System.out.println("123");
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
		
		@RequestMapping(value = "/testJson",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson testjson(){
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<Folder> userList = new ArrayList<Folder>();
			userList.add(new Folder("妗妗1","1","男"));
			userList.add(new Folder("妗妗12","1","男"));
			userList.add(new Folder("妗妗13","1","男"));
			json.setData(userList);
	        return json;
	    }

		

}
