package com.chinasofti.ssm01.entity;

import com.chinasofti.ssm01.util.BaseBean;
/**
 * 保存文件的实体
 * @author zhuying
 *
 */
public class FileInfo extends BaseBean{ 
	private Integer fileId;
	private String fileName;
	private String fileUrl;
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
}
