package com.emsystem.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.dao.CardHolderDao;
import com.emsystem.pojo.CardHolder;
import com.emsystem.pojo.ObjectRlationJson;


/*
 * 实现功能：名片夹的控制器
 * 分工：丁亚东
 * 日期：2020/7/15
 * 
 */

@Controller
public class CardHolderController {
  @Autowired
  CardHolderDao dao;
	
  //显示所有名片
	@RequestMapping(value = "/cardHolderList",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderList(){
		ObjectRlationJson json = new ObjectRlationJson();
		List<CardHolder> List = dao.queryAll();
		json.setData(List);
        return json;
    }
	
	  //显示所有名片
		@RequestMapping(value = "/insertCart",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson insertCart(CardHolder card) throws SQLException{
			ObjectRlationJson json = new ObjectRlationJson();
			
			int insertNum = dao.addCard(card);
			if(insertNum!=0){
				json.setMsg("添加成功！");
			}else {
				json.setMsg("添加失败！");
			}
	        return json;
	    }
	
	//显示分类
	@RequestMapping(value = "/cardHolderClassify",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderClassify(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
		json.setData(userList);
        return json;
    }
}
