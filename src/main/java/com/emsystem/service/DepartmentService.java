package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.Department;

public interface DepartmentService {
	//查询全部
	List<Department> queryAll();
	//通过id查询单条
	public Department querySingle(int id);
	//新增
	boolean save(Department d);
	//编辑类型
	public boolean update(Department d);
	//删除
	int delete(int did);
}
