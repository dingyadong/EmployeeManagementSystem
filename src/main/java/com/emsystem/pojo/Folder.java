package com.emsystem.pojo;

public class Folder {
String folderName;
String folderTime;
String conent;
boolean shareStatus;


public boolean isShareStatus() {
	return shareStatus;
}


public void setShareStatus(boolean shareStatus) {
	this.shareStatus = shareStatus;
}


public String getFolderName() {
	return folderName;
}


public void setFolderName(String folderName) {
	this.folderName = folderName;
}


public String getFolderTime() {
	return folderTime;
}


public void setFolderTime(String folderTime) {
	this.folderTime = folderTime;
}


public String getConent() {
	return conent;
}


public void setConent(String conent) {
	this.conent = conent;
}


public Folder(String folderName, String folderTime, String conent) {
	this.folderName=folderName;
	this.folderTime=folderTime;
	this.conent=conent;
}

}
