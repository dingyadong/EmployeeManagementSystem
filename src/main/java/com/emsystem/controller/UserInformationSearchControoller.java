package com.emsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.emsystem.service.UserInformationSearchService;

@Controller
	public class UserInformationSearchControoller {
<<<<<<< HEAD
	@Autowired
	private UserInformationSearchService userS;
	//查询
=======
	@Autowired  
	private UserLoginService userServicelogin;

	// 登陆
>>>>>>> branch 'ceshi' of https://github.com/dingyadong/EmployeeManagementSystem.git
	@RequestMapping("selectByName")
	public String selectByName(String name, Model model) {
		model.addAttribute("UserList", userS.queryByName(name));
		return "page/table";
		}

}
