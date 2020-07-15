package com.emsystem.pojo;

public class Folder {
String folderName;
String fileTime;
String conent;

public String getFolderName() {
	return folderName;
}
public void setFolderName(String folderName) {
	this.folderName = folderName;
}
public String getFileTime() {
	return fileTime;
}
public void setFileTime(String fileTime) {
	this.fileTime = fileTime;
}
public String getConent() {
	return conent;
}
public void setConent(String conent) {
	this.conent = conent;
}

public Folder(String folderName, String fileTime, String conent) {
	this.folderName=folderName;
	this.fileTime=fileTime;
	this.conent=conent;
}

}
