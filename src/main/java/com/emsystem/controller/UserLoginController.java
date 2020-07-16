package com.emsystem.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.File;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.pojo.UserLogin;
import com.emsystem.service.UserLoginService;
import com.emsystem.utils.StrUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
	public class UserLoginController {
	@Autowired
	private UserLoginService userServicelogin;

	// 登陆
	@RequestMapping("userlogin")
	public String login(String username, String password, Model model, HttpSession session) {
		if (!StrUtils.empty(username, password)) {
			UserLogin userlogin = userServicelogin.getUserByName(username);
			if (userlogin != null) {
				// 校验密码
				if (userlogin.getPassword().equals(password)) {
					// 正确
					// 记录登录信息到会话中
					session.setAttribute("userlogin", userlogin);
					// 页面跳转
					return "index";
				}
			}
		}
		model.addAttribute("loginMsg", "用户名或密码错误");
		return "login";
	}	

}
