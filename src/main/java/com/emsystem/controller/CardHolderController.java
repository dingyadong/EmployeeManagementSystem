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
import com.emsystem.pojo.CardHolderClass;
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
    public ObjectRlationJson cardHolderList(String keyword1,String keyword2){
		System.out.println(keyword1+keyword2);
		ObjectRlationJson json = new ObjectRlationJson();
		List<CardHolder> List = dao.queryAllName_card();
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
				json.setMsg("添加成功！");
			}else {
				json.setMsg("添加失败！");
			}
	        return json;
	    }
		
		@RequestMapping(value = "/cardKeyWord",produces ={ "application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson cardKeyWord1(String keyword1,String keyword2){
			System.out.println(keyword1+keyword2);
			System.out.println("测试成功！");
			ObjectRlationJson json = new ObjectRlationJson();
			List<CardHolder> List;
			if(keyword1 !=null & keyword2 != null){
				List = dao.queryName_cardByKeyWord(keyword1,keyword2);
			}else if (keyword1 !=null) {
				 List = dao.queryName_cardByKeyWord1(keyword1);
			}else {
				 List = dao.queryName_cardByKeyWord2(keyword2);
			}
			
			json.setData(List);
			System.out.println(json);
	        return json;
	    }
		
		

		
				@RequestMapping(value = "/insertCartClass",produces ={ "application/json;charset=UTF-8"})
			    @ResponseBody
			    public ObjectRlationJson insertCartClass(CardHolderClass card) throws SQLException{
					ObjectRlationJson json = new ObjectRlationJson();
					
					int insertNum = dao.addCardClass(card);
					if(insertNum!=0){
						json.setMsg("添加成功！");
					}else {
						json.setMsg("添加失败！");
					}
			        return json;
			    }
				
	//��ʾ����
	@RequestMapping(value = "/cardHolderClassify",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson cardHolderClassify(){
		ObjectRlationJson json = new ObjectRlationJson();
		  
		List<CardHolderClass> userList = dao.queryCardClass();
		json.setData(userList);
        return json;
    }
	
	
	
}
