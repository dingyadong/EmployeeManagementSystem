package com.chinasofti.ssm01.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinasofti.ssm01.dao.GoodsInfoDao;
import com.chinasofti.ssm01.entity.GoodsInfo;
import com.chinasofti.ssm01.service.GoodsInfoService;

@Service
@Transactional
public class GoodsInfoServiceImpl implements GoodsInfoService {

	@Autowired
	private GoodsInfoDao goodsdao;

	public void add(GoodsInfo info) {
		goodsdao.add(info);
	}

	@Transactional(readOnly=true)
	public List<Map> getlist(GoodsInfo info) {
		// TODO Auto-generated method stub
		return goodsdao.getList(info);
	}

	@Transactional(readOnly=true)
	public Map getGoodsInfo(GoodsInfo info) {
		// TODO Auto-generated method stub
		return goodsdao.getGoodsInfo(info);
	}

}
