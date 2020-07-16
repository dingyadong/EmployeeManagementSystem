package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.Department;

public interface DepartmentDao {
	//查询全部
	@Select("select * from department")
	@ResultType(Department.class)
	List<Department> queryAll();
	//通过id查询类型
	@Select("select * from department where department_id=#{department_id}")
	public Department querySingle(int department_id);
	//新增
	@Insert("insert into department(depament_name) values(#{depament_name})")
	int save(Department d);
	//编辑
	@Update("update department set depament_name=#{depament_name} where department_id=#{department_id}")
	int update(Department d);
	//根据id删除商品类型
	@Delete("delete from department where department_id=#{department_id}")
	public int delete(@Param("department_id")int did);
}
