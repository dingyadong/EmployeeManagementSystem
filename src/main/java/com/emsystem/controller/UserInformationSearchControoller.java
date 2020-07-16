package com.emsystem.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Folder;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.pojo.UserLogin;
import com.emsystem.service.UserLoginService;
import com.emsystem.utils.StrUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
	public class UserInformationSearchControoller {
	@Autowired
	private UserLoginService userServicelogin;

	// 登陆
	@RequestMapping("selectByName")
	public String selectByName(String name, Model model) {
		model.addAttribute("glist", goodsService.queryByName(name));
		return "page/table";
		}

}
