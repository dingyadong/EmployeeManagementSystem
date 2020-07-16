package com.emsystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Boardroom;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.BoardroomService;

public class BoardroomController {
	@Autowired
	private BoardroomService service;
	
	
	//查询全部
	@RequestMapping(value = "/boardroomjson",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson testjson(){
		ObjectRlationJson json = new ObjectRlationJson();
		
		List<Boardroom> boardroomList = service.selectAll();
		json.setData(boardroomList);
        return json;
    }
	
		
	
}
