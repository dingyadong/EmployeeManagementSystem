package com.emsystem.service;

import java.util.List;

import com.emsystem.pojo.Deptment;

public interface DeptmentService {
	//查询全部
	List<Deptment> queryAll();
	//通过id查询类型
	public Deptment querySingle(int id);
	//新增
	boolean save(Deptment d);
	//编辑类型
	public boolean update(Deptment d);
	//删除
	int delete(int did);
}
