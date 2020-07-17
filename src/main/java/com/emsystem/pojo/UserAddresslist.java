package com.emsystem.pojo;

public class UserAddresslist {
  private int addresslist_id;
  private String user_name;
  private String department_name;
  private String telephone;


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
public int getAddresslist_id() {
	return addresslist_id;
}
public void setAddresslist_id(int addresslist_id) {
	this.addresslist_id = addresslist_id;
}
@Override
public String toString() {
	return "UserAddresslist [addresslist_id=" + addresslist_id + ", user_name=" + user_name + ", department_name="
			+ department_name + ", telephone=" + telephone + "]";
}

  
}
