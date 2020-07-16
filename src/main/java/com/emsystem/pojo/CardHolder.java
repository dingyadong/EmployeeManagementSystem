package com.emsystem.pojo;

public class CardHolder {
	String name;
	String tel;
	String compliy;
	String location;
	public CardHolder(String name, String tel, String compliy,String location) {
		this.name = name;
		this.tel = tel;
		this.compliy = compliy;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCompliy() {
		return compliy;
	}
	public void setCompliy(String compliy) {
		this.compliy = compliy;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
