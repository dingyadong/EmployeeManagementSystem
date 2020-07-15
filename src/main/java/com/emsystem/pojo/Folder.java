package com.emsystem.pojo;

public class Folder {
String folderName;
String folderTime;
String conent;

public String getFolderName() {
	return folderName;
}
public void setFolderName(String folderName) {
	this.folderName = folderName;
}
public String getFileTime() {
	return folderTime;
}
public void setFileTime(String fileTime) {
	this.folderTime = fileTime;
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
