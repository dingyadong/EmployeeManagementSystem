package com.emsystem.pojo;

public class Schedulingprogram {
private int sp_id;
private int user_id;
private  String date;
private String object;
public int getSp_id() {
	return sp_id;
}
public void setSp_id(int sp_id) {
	this.sp_id = sp_id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getObject() {
	return object;
}
public void setObject(String object) {
	this.object = object;
}
@Override
public String toString() {
	return "Schedulingprogram [sp_id=" + sp_id + ", user_id=" + user_id + ", date=" + date + ", object=" + object + "]";
}


}
