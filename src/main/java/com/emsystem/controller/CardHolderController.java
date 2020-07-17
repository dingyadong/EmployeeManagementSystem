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
 * ʵ�ֹ��ܣ���Ƭ�еĿ�����
 * �ֹ������Ƕ�
 * ���ڣ�2020/7/15
 * 
 */

@Controller
public class CardHolderController {
  @Autowired
  CardHolderDao dao;
	
  //��ʾ������Ƭ
	@RequestMapping(value = "/cardHolderList",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderList(){
		ObjectRlationJson json = new ObjectRlationJson();
		List<CardHolder> List = dao.queryAll();
		json.setData(List);
        return json;
    }
	
	  //��ʾ������Ƭ
		@RequestMapping(value = "/insertCart",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson insertCart(CardHolder card) throws SQLException{
			ObjectRlationJson json = new ObjectRlationJson();
			
			int insertNum = dao.addCard(card);
			if(insertNum!=0){
				json.setMsg("��ӳɹ���");
			}else {
				json.setMsg("���ʧ�ܣ�");
			}
	        return json;
	    }
	
	//��ʾ����
	@RequestMapping(value = "/cardHolderClassify",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderClassify(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolder> userList = new ArrayList<CardHolder>();
		json.setData(userList);
        return json;
    }
}
