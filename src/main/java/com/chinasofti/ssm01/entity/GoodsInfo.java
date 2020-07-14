package com.chinasofti.ssm01.entity;

import com.chinasofti.ssm01.util.BaseBean;

/**
 * 商品信息
 * @author Administrator
 *
 */
public class GoodsInfo extends BaseBean{

	public Integer goodsId;
	
	public String goodsName;
	
	public Double goodsPrice;
	
	private String goodsUrl;
	
	private String goodsDesc;
	
	private String goodsState;

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(String goodsState) {
		this.goodsState = goodsState;
	}

	@Override
	public String toString() {
		return "GoodsInfo [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ ", goodsUrl=" + goodsUrl + ", goodsDesc=" + goodsDesc + ", goodsState=" + goodsState + "]";
	}
	
	
}
