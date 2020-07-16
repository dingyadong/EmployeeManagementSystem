package com.emsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
  
	
	@RequestMapping(value = "/cardHolderList",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderList(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
        return json;
    }
	

	@RequestMapping(value = "/cardHolderClassify",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderClassify(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
		json.setData(userList);
        return json;
    }
}
