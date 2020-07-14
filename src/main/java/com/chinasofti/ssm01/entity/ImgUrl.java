package com.chinasofti.ssm01.entity;

public class ImgUrl {

	private String path;//"upload/" + format + ".jpg"
	
	private String url;//http://localhost:8080/shop_img/"upload/" + format + ".jpg"

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
