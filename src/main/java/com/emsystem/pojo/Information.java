package com.emsystem.pojo;

public class Information {
private int information_id;
private String date;
private String message;
public int getInformation_id() {
	return information_id;
}
public void setInformation_id(int information_id) {
	this.information_id = information_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "Information [information_id=" + information_id + ", date=" + date + ", message=" + message + "]";
}

}
