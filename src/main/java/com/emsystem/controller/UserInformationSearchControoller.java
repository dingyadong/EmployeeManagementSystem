package com.emsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emsystem.service.UserInformationSearchService;

@Controller
	public class UserInformationSearchControoller {
	@Autowired
	private UserInformationSearchService userS;

	// 查询模糊
	@RequestMapping("selectByName")
	public String selectByName(String name, Model model) {
		model.addAttribute("UserList", userS.queryByName(name));
		return "page/table";
		}

}
