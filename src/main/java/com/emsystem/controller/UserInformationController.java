package com.emsystem.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.pojo.UserInformation;
import com.emsystem.service.UserInformationService;

@Controller
	public class UserInformationController {
	@Autowired
	private UserInformationService userI;

	// 查询模糊
	@RequestMapping("selectByName")
	public String selectByName1(String name, Model model) {
		model.addAttribute("UserList", userI.queryByName(name));
		return "page/table";
		}
	
	// 查看商品列表
	@RequestMapping(value = "/getallusers",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showjson() {
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(userI.queryAll());
		return json;
	}
//	@RequestMapping(value = "/deptmentjson",produces ={ "application/json;charset=UTF-8"})
//	@ResponseBody
//	public ObjectRlationJson showjson() {
//		ObjectRlationJson json = new ObjectRlationJson();
//		json.setData(service.queryAll());
//		return json;
//	}
	
	
	// 员工新增
	@RequestMapping(value = "/adduser")
    @ResponseBody
    public String save1(MultipartFile file, UserInformation user, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (userI.save(user)) {
			System.out.print("成功");
			return "index";
		} else {
			System.out.print("失败");
			return "index";
		}
	}
}



