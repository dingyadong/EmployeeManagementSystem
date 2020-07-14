package com.chinasofti.ssm01.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/*.xml"})
@WebAppConfiguration
public class UserInfoControllerTest {
	
	@Autowired(required=true)
	public WebApplicationContext wac;

	public MockMvc mockMvc;
	private MockHttpSession session;

	@Before
	public void before() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		session = new MockHttpSession();
	}

	@Test
	public void testLoginByGet() {
		try {
			MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.get("/user/login.do?userAccount=10001&userPassword=abc123")
					.session(session))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			System.out.println("loginUser = " + session.getAttribute("loginUser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginByPost() {
		try {
			MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.post("/user/login.do")
					.param("userAccount", "10001")
					.param("userPassword", "abc123")
					.session(session))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			System.out.println("loginUser = " + session.getAttribute("loginUser"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
