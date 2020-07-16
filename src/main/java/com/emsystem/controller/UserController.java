package com.emsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.UserService;
/**
* @Description: 用户的servlet(增删改查) 此处用的springMVC框架直接用注解的方式
* @author 甘天龙
* @date 2020年7月16日  
* @version V1.0 
 */
@Controller
public class UserController {
	@Autowired
	private UserService service;

	/**
	 * 查询到用户列表json
	 * @return
	 */
	@RequestMapping(value = "/userlistjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showUserlistjson() {
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(service.queryAll());
		return json;
	}
}
