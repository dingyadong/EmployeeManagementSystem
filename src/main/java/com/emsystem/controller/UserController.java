package com.emsystem.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Department;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.pojo.User;
import com.emsystem.service.UserService;
/**
* @Description: 用户的servlet(增删改查) 此处用的springMVC框架直接用注解的方式
* @author 甘天龙
* @date 2020年7月16日  
* @version V1.0 
 */
@Controller
public class UserController {
	@Autowired
	private UserService service;

	/**
	 * 查询到用户列表json
	 * @return
	 */
	@RequestMapping(value = "/userlistjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showUserlistjson() {
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(service.queryAll());
		return json;
	}
	/**
	 * 部门添加
	 * @param d前台传过来的departmen对象
	 * @return
	 */
	@RequestMapping(value ="/adduser",produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson adduserjson(User u){
		ObjectRlationJson json = new ObjectRlationJson();
		if(service.save(u)){
			json.setMsg("添加成功！");
		}else{
			json.setMsg("添加失败！");
		}
		//System.out.println(d.getDepartment_id());
		return json;
	}
	/**
	 * 编辑功能
	 * @param d
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/upDateUserById",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson upDateUserById(User u) throws SQLException{
		ObjectRlationJson json = new ObjectRlationJson();

		if(service.update(u)){
			json.setMsg("更新成功！");
		}else {
			json.setMsg("更新失败！");
		}
        return json;
    }
}
