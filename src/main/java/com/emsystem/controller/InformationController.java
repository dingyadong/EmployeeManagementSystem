package com.emsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.InformationService;



@Controller
public class InformationController {
	/**
	 * 查询
	 */
	
	@Autowired
    private InformationService informationlist;
	
	@RequestMapping(value = "/informationjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showuseraddresslist(){	
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(informationlist.queryAll());  
	    return json;
	}
}
