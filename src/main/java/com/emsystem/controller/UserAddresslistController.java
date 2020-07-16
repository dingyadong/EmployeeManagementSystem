package com.emsystem.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.dao.UserAddresslistDao;
import com.emsystem.pojo.File;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.UserAddressService;

/**
 * @category 通讯录
 * @author jingc
 * @date 2020.7.16
 */

@Controller
public class UserAddresslistController {
	
	
	/**
	 * 查询
	 */
	
	@Autowired
    private UserAddressService useraddresslist;
	
	@RequestMapping(value = "/ualjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showuseraddresslist(){	
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(useraddresslist.queryAll());
	    return json;
	}
	
	/**
	 * 删除
	 */
	
	@Autowired 
	private UserAddresslistDao UserAddresslistDao;
	@RequestMapping(value = "/dualjson",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson delete(File fileInfo) throws SQLException{
		ObjectRlationJson json = new ObjectRlationJson();
		
		int deleteNum = UserAddresslistDao.delete(fileInfo.getFile_id());
		if(deleteNum!=0){
			json.setMsg("删除成功");
		}else {
			json.setMsg("删除失败");
		}
        return json;
	}
	
	
	
}


