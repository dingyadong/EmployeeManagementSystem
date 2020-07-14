package com.chinasofti.ssm01.dao;

import java.util.List;
import java.util.Map;

import com.chinasofti.ssm01.entity.GoodsInfo;

/**
 * 商品管理的数据访问接口
 * @author Administrator
 *
 */
public interface GoodsInfoDao {

	/**
	 * 添加商品
	 * @param info
	 * @return
	 */
	public void add(GoodsInfo info);
	
	/**
	 * 查询商品
	 * @param info
	 * @return
	 */
	public List<Map> getList(GoodsInfo info);
	
	/**
	 * 根据条件查询商品信息
	 * @param info
	 * @return
	 */
	public Map getGoodsInfo(GoodsInfo info);
	
}
