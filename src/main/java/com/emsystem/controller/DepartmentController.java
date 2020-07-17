package com.emsystem.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Department;
import com.emsystem.pojo.ObjectRlationJson;
import com.emsystem.service.DepartmentService;

/**
* @Description: 部门的servlet(增删改查) 此处用的springMVC框架直接用注解的方式
* @author 
* @date 2020年7月16日  
* @version V1.0 
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	

	@RequestMapping(value = "/deptmentjson",produces ={ "application/json;charset=UTF-8"})
	@ResponseBody
	public ObjectRlationJson showjson() {
		ObjectRlationJson json = new ObjectRlationJson();
		json.setData(service.queryAll());
		return json;
	}

	/**
	 * 编辑功能
	 * @param d
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/upDatedepartmentById",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson upDatedepartmentById(Department d) throws SQLException{
		ObjectRlationJson json = new ObjectRlationJson();
		System.out.println(d.getDepartment_id()+d.getDepatment_name());
		if(service.update(d)){
			json.setMsg("更新成功！");
		}else {
			json.setMsg("更新失败！");
		}
        return json;
    }

}
