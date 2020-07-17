package com.emsystem.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.dao.UserAddresslistDao;
import com.emsystem.pojo.File;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.pojo.UserAddresslist;
import com.emsystem.service.UserAddressService;

/**
 * @category 通讯录
 * @author jingc
 * @date 2020.7.16
 */

@Controller
public class UserAddresslistController {
	@Autowired
    private UserAddressService useraddresslist;
	@Autowired 
    UserAddresslistDao UserAddresslistDao;
	
	/**
	 * 查询
	 */
	
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
	

	@RequestMapping(value = "/dualjson",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson delete(UserAddresslist fileInfo) throws SQLException{
		
		ObjectRlationJson json = new ObjectRlationJson();
		
		int deleteNum = UserAddresslistDao.delete(fileInfo.getAddresslist_id());
		if(deleteNum!=0){
			json.setMsg("删除成功");
		}else {
			json.setMsg("删除失败");
		}
        return json;
	}	
	
	/**
	 * 增加
	 *  
	 */
	@RequestMapping(value = "/inserjson",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson insertFile(UserAddresslist file){
		
		ObjectRlationJson json = new ObjectRlationJson();
		
		List<UserAddresslist> userList = new ArrayList<UserAddresslist>();

		json.setData(userList);
		System.out.println("OK");
		System.out.println(file.getUser_name()+file.getDepartment_name());
        return json;
    }
	
}


