package com.emsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.emsystem.pojo.Deptment;

public interface DeptmentDao {
	//查询全部
	@Select("select * from deptment")
	@ResultType(Deptment.class)
	List<Deptment> queryAll();
	//通过id查询类型
	@Select("select * from deptment where department_id=#{department_id}")
	public Deptment querySingle(int department_id);
	//新增
	@Insert("insert into deptment(depament_name) values(#{depament_name})")
	int save(Deptment d);
	//编辑
	@Update("update deptment set depament_name=#{depament_name} where department_id=#{department_id}")
	int update(Deptment d);
	//根据id删除商品类型
	@Delete("delete from deptment where department_id=#{department_id}")
	public int delete(@Param("department_id")int did);
}
