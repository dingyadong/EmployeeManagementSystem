package com.emsystem.pojo;

public class UserAddresslist {
  private int user_id;
  private String user_name;
  private String department_name;
  private String telephone;
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getDepartment_name() {
	return department_name;
}
public void setDepartment_name(String department_name) {
	this.department_name = department_name;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
@Override
public String toString() {
	return "UserAddresslist [user_id=" + user_id + ", user_name=" + user_name + ", department_name=" + department_name
			+ ", telephone=" + telephone + "]";
}
  
}
