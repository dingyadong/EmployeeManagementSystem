package com.emsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.CardHolder;
import com.emsystem.pojo.ObjectRlationJson;


/*
 * ʵ�ֹ��ܣ���Ƭ�еĿ�����
 * �ֹ������Ƕ�
 * ���ڣ�2020/7/15
 * 
 */  

@Controller
public class CardHolderController {
  
	
	@RequestMapping(value = "/cardHolderList",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderList(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		json.setData(userList);
        return json;
    }
	

	@RequestMapping(value = "/cardHolderClassify",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderClassify(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		userList.add(new CardHolder("张三","17324785","科创","经理"));
		json.setData(userList);
        return json;
    }
}
