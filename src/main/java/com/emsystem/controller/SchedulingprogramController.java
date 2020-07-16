package com.emsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.SchedulingprogramService;

/**
 * @category 代办事项
 * @author jingc
 *
 */
@Controller

public class SchedulingprogramController {
	/**
	 * 查询
	 */
	
	
	@Autowired
	private SchedulingprogramService schedulingplist;
	@RequestMapping(value = "/schedljson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showuseraddresslist(){	
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(schedulingplist.queryAll());  
	    return json;
	}
}
