package com.emsystem.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.emsystem.pojo.UserInformation;
import com.emsystem.service.UserInformationService;

@Controller
	public class UserInformationController {
	@Autowired
	private UserInformationService userI;

	// 查询模糊
	@RequestMapping("selectByName")
	public String selectByName(String name, Model model) {
		model.addAttribute("UserList", userI.queryByName(name));
		return "page/table";
		}
	
	// 查看商品列表
	@RequestMapping("getallusers")
	public String goodslist(Model model) {
		model.addAttribute("goodsList", userI.queryAll());
		return "admin/showGoods";
	}
	
	// 员工新增
	@RequestMapping("adduser")
	public String save(MultipartFile file, UserInformation user, HttpServletRequest request)
			throws IllegalStateException, IOException {
		if (userI.save(user)) {
			return "index";
		} else {
			request.setAttribute("msg", "添加失败，重新再来");
			return "index";
		}
	}
}
