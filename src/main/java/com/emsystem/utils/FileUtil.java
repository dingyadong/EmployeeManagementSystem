package com.emsystem.utils;

import java.io.ByteArrayInputStream; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void copyFileToDisk(String fileUrl, MultipartFile mulFile) throws IOException{
		FileOutputStream fos = new FileOutputStream(new File(fileUrl));
		fos.write(mulFile.getBytes());
		fos.flush();
		fos.close();
	}
	
//	public static File readFileFromDisk(String fileUrl) throws FileNotFoundException{
////		FileInputStream fis = new FileInputStream(new File(fileUrl));
////		FileOutputStream fos = new FileOutputStream(File.createTempFile("temp", ""));
////		byte[] b = new 
//	}
	
	public static String createRandomFileName(){
		String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return format;
	}
}
