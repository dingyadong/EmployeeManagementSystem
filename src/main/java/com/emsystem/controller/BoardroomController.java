package com.emsystem.controller;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


import com.emsystem.dao.BoardroomDao;
import com.emsystem.pojo.Boardroom;

import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.BoardroomService;
@Controller
/*
 * 会议室管理
 * 实现人：蒋旭
 * 
 */


public class BoardroomController {
	@Autowired
	BoardroomDao dao;
	@Autowired
	 BoardroomService service;
   
	      
	
	//查询全部
	 @RequestMapping(value = "/boardroomList",produces ={"application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson boardroomList() throws SQLException{
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<Boardroom> boardroomList = service.BoardroomList();
			json.setData(boardroomList);
	        return json;
	    }
	  
	//根据id查询
	 @RequestMapping(value = "/selectById",produces ={"application/json;charset=UTF-8"})
	 @ResponseBody
	    public ObjectRlationJson selectById() throws SQLException{
			ObjectRlationJson json = new ObjectRlationJson();
			
			List<Boardroom> selectByIdList = service.OrderdBoardroomList();
			json.setData(selectByIdList);
	        return json;
	    }    
	 //添加  
	 @RequestMapping(value = "/insertBoardroom",produces ={"application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson insertBoardroom(Boardroom boardroom) throws SQLException{
			
			ObjectRlationJson json = new ObjectRlationJson();
			
			int insertNum=dao.addBoardroomInfo(boardroom);
			if(insertNum!=0){
				json.setMsg("添加成功");
			}
			else{
				json.setMsg("添加失败");
			}
			return json;
	    }
	 //删除
	 @RequestMapping(value = "/deleteBoardroomById",produces ={"application/json;charset=UTF-8"})
	    @ResponseBody
	    public ObjectRlationJson deleteBoardroom(Boardroom boardrominfo) throws SQLException{
			ObjectRlationJson json = new ObjectRlationJson();
			
			int deleteNum = dao.deleteBoardroomById(boardrominfo.getBoardroom_id());
			if(deleteNum!=0){
				json.setMsg("删除成功！");
			}else {
				json.setMsg("删除失败！");
			}
	        return json;
	    }
	
}
