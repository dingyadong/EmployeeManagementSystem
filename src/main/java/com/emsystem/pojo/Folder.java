package com.emsystem.pojo;

public class Folder {
String folderName;
String folderTime;
String content;
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



public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public Folder(String folderName, String folderTime, String content) {
	this.folderName=folderName;
	this.folderTime=folderTime;
	this.content=content;
}

}
