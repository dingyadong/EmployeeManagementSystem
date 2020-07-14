package com.emSystem.pojo;

public class Folder {
String folderName;
String date;
String neirong;
public Folder(String string, String string2, String string3) {
	this.folderName = string;
	this.date = string2;
	this.neirong = string3;
	
}
public String getFolderName() {
	return folderName;
}
public void setFolderName(String folderName) {
	this.folderName = folderName;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getNeirong() {
	return neirong;
}
public void setNeirong(String neirong) {
	this.neirong = neirong;
}
}
