package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emsystem.dao.DepartmentDao;
import com.emsystem.pojo.Department;
import com.emsystem.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao dao;
	@Override
	public List<Department> queryAll() {
		return dao.queryAll();
	}

	@Override
	public Department querySingle(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Department d) {
		// TODO Auto-generated method stub
		return dao.save(d)>0;
	}

	@Override
	public boolean update(Department d) {
		// TODO Auto-generated method stub
		return dao.update(d)>0;
	}

	@Override
	public int delete(int did) {
		// TODO Auto-generated method stub
		return 0;
	}

}
