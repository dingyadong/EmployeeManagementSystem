package com.emsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Department;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.DepartmentService;

/**
* @Description: 商品类型的servlet(增删改查) 此处用的springMVC框架直接用注解的方式
* @author 
* @date 2020年7月16日  
* @version V1.0 
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	//goodstypejson
	// 显示类型
	@RequestMapping(value = "/deptmentjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showjson() {
		ObjectRlationJson json = new ObjectRlationJson();

		json.setData(service.queryAll());
		return json;
	}
	
//	@RequestMapping(value = "/folderList",produces ={ "application/json;charset=UTF-8"})
//    @ResponseBody
//    public ObjectRlationJson testjson(){
//		ObjectRlationJson json = new ObjectRlationJson();
//		
//		List<Folder> userList = new ArrayList<Folder>();
//		userList.add(new Folder("妗妗1","2020/07/10 11:05:41","男"));
//		userList.add(new Folder("妗妗12","2020/07/10 11:05:41","男"));
//		userList.add(new Folder("妗妗13","2020/07/10 11:05:41","男"));
//		json.setData(userList);
//        return json;
//    }
}
