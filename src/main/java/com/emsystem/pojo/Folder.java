package com.emsystem.pojo;

public class Folder {
	private Integer folderId;
	private String folderUrl;
	private String folderName;
	private String folderTime;
	private String content;
	private int shareStatus;




public Integer getFolderId() {
		return folderId;
	}




	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}




	public String getFolderUrl() {
		return folderUrl;
	}




	public void setFolderUrl(String folderUrl) {
		this.folderUrl = folderUrl;
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




	public int getShareStatus() {
		return shareStatus;
	}




	public void setShareStatus(int shareStatus) {
		this.shareStatus = shareStatus;
	}

	public Folder() {
	
	}


public Folder(String folderName, String folderTime, String content) {
	this.folderName=folderName;
	this.folderTime=folderTime;
	this.content=content;
}

}
