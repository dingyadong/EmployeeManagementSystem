package com.chinasofti.ssm01.service;

import java.util.List;
import java.util.Map;

import com.chinasofti.ssm01.entity.GoodsInfo;


/**
 * 商品管理的业务逻辑接口
 * @author Administrator
 *
 */
public interface GoodsInfoService {

	/**
	 * 添加商品
	 * @param info
	 */
	public void add(GoodsInfo info);
	
	/**
	 * 查询商品信息
	 * @param info
	 * @return
	 */
	public List<Map> getlist(GoodsInfo info);
	
	/**
	 * 根据条件查询商品信息
	 * @param info
	 * @return
	 */
	public Map getGoodsInfo(GoodsInfo info);
	
}
