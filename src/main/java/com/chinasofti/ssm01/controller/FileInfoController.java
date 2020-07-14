package com.chinasofti.ssm01.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.ssm01.dao.FileInfoDao;
import com.chinasofti.ssm01.entity.FileInfo;
import com.chinasofti.ssm01.util.FileUtil;



@Controller
@RequestMapping("/file")
public class FileInfoController {
	
//	private FileInfoDao fileInfoDao = new FileInfoDaoImpl();;
	@Autowired
	private FileInfoDao fileInfoDao;

	@RequestMapping("/upload")
	public String upload(){
		return "upload";
	}
	
	@RequestMapping("/doupload")
	public String doUpload(@RequestParam(required=false) MultipartFile mulFile,HttpServletRequest request){
		System.out.println("file name = " + mulFile.getName());
		System.out.println("file real name = " + mulFile.getOriginalFilename());
		String fileUrl = "/upload/" + 
				FileUtil.createRandomFileName() + mulFile.getOriginalFilename();
		fileUrl = request.getServletContext().getRealPath(fileUrl);
		System.out.println("file real url = " + fileUrl);
		
		try {
			FileUtil.copyFileToDisk(fileUrl, mulFile);
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFileName(mulFile.getOriginalFilename());
			fileInfo.setFileUrl(fileUrl);
			
			fileInfoDao.addFileInfo(fileInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
	
	@RequestMapping("/list")
	public String list(HttpSession session){
		try {
			List<FileInfo> files = fileInfoDao.getFileInfos(null);
			session.setAttribute("files", files);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(FileInfo fileInfo) {
		try {
			System.out.println("fileInfo.fileId = " + fileInfo.getFileId());
			List<FileInfo> files = fileInfoDao.getFileInfos(fileInfo);
			String fileUrl = files.get(0).getFileUrl();
			String fileName = files.get(0).getFileName();
			HttpHeaders headers = new HttpHeaders();//httpͷ��Ϣ
			headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("UTF-8"),"iso-8859-1"));
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//MediaType:������ý������  contentType�����������е�ý��������Ϣ
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)),headers,HttpStatus.CREATED);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
