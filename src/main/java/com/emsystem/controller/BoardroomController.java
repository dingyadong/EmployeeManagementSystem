package com.emsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Boardroom;
import com.emsystem.pojo.Folder;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.BoardroomService;

public class BoardroomController {
	@Autowired
	private BoardroomService service;
	
	
	@RequestMapping(value = "/testJson",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson testjson(){
		ObjectRlationJson json = new ObjectRlationJson();
		
		List<Boardroom>boardroomList = new ArrayList<Boardroom>();
		boardroomList.add(new Boardroom(""));
		json.setData(boardroomList);
        return json;
    }
	
		
	
}
