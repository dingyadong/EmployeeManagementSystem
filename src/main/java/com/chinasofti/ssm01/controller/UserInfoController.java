package com.chinasofti.ssm01.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.ssm01.entity.UserInfo;
import com.chinasofti.ssm01.service.UserInfoService;
import com.chinasofti.ssm01.util.BaseController;
import com.chinasofti.ssm01.util.Common;
import com.chinasofti.ssm01.util.FaceClient;
import com.google.gson.JsonObject;


@Controller
@RequestMapping("/user")
public class UserInfoController extends BaseController{
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/login")
	public String doLogin(UserInfo userInfo,HttpSession session) {
		System.out.println("user do login");
		System.out.println("user account = " + userInfo.getUserAccount());
		System.out.println("user Password = " + userInfo.getUserPassword());
		UserInfo loginUser = userInfoService.doLogin(userInfo);
		if(loginUser != null){
			return index(loginUser, session);
		}
		return "login";
	}
	
	public String index(UserInfo loginUser,HttpSession session){
		session.setAttribute("loginUser", loginUser);
		return "index";
	}
	
	@RequestMapping("/update")
	public String update(UserInfo userInfo,HttpSession session){
		UserInfo updateUser = userInfoService.getUpdateUserInfoById(userInfo);
		if(updateUser != null){
			session.setAttribute("updateUser", updateUser);
			return "user_info_update";
		}
		return "index";
	}
	
	@RequestMapping("/doupdate")
	public String doSelfUpdate(UserInfo userInfo,HttpSession session,HttpServletRequest request,Model model){
		userInfoService.updateUserInfo(userInfo);
		return showAll(null, session, request, model);
	}
	
	
	@RequestMapping("/list")
	public String showAll(UserInfo userInfo,HttpSession session,HttpServletRequest request,Model model){
		initPage(request);
		if(userInfo != null){
			initPage(request);
			userInfo.setStart(getPageNo());//璧峰璁板綍鏁�
			userInfo.setLength(PAGE_NUM);
		}else{
			userInfo = new UserInfo();
			userInfo.setLength(PAGE_NUM);
		}
		
		
		try {
			if(userInfo.getUserName() != null){
				System.out.println(userInfo.getUserName());
				System.out.println(new String(userInfo.getUserName().getBytes("ISO-8859-1"),"UTF-8"));
			}			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("queryname", userInfo.getUserName());
		model.addAttribute("queryaccount",userInfo.getUserAccount()); 
		
		model.addAttribute("userinfolist", userInfoService.getUserInfoList(userInfo));
		//锟杰硷拷录锟斤拷
		Long total = userInfoService.getUserInfoListCount(userInfo);
		model.addAttribute("total", total);
		return "user_info_list";
	}
	
	@RequestMapping("/delete")
	public String delete(UserInfo userInfo,HttpSession session,HttpServletRequest request,Model model,HttpServletResponse response){
		userInfoService.deleteUserInfo(userInfo);
		return showAll(null, session, request, model);
	}
	
	@RequestMapping("/faceRegister")
	public void faceRegister(HttpServletRequest request,HttpSession session,@RequestParam("base") String base,HttpServletResponse response){
		JsonObject json = new JsonObject();
		json.addProperty("message", "");
		UserInfo userInfo = (UserInfo)session.getAttribute("loginUser");
		
		String path=request.getServletContext().getRealPath("/")+"headPhoto\\" ;
	       
        String urlPath=request.getContextPath() + "/headPhoto/"+userInfo.getUserId()+".jpg";
        File uploadDir = new File(path);
        if (!uploadDir.exists() && !uploadDir.isDirectory()) {// 检查目录
			uploadDir.mkdirs();
		}
        path+=userInfo.getUserId()+".jpg";
		OutputStream out = null;
        InputStream is = null;
        System.out.println("aaaaa=="+path);
		try {
			byte[] imgByte  = Base64.decodeBase64(base); 
			for (int i = 0; i < imgByte.length; ++i) {
				if (imgByte[i] < 0) {// 调整异常数据
				imgByte[i] += 256;
				}
			}
			out = new FileOutputStream(path);
			is = new ByteArrayInputStream(imgByte);
			byte[] buff = new byte[1024];
	        int len = 0;
	        while((len=is.read(buff))!=-1){
	            out.write(buff, 0, len);
	        }
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			json.addProperty("message", "注册失败");
			e.printStackTrace();
			this.writeJson(json.toString(), response);
		}finally{
			if(is!=null){
				try {
					is.close();
			       
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		userInfo.setUserFaceUrl(urlPath);
		userInfo.setUserFacePath(path);
		userInfoService.updateUserInfo(userInfo);
		json.addProperty("message", "注册成功");
		writeJson(json.toString(), response);
	}
	
	@RequestMapping("/faceLogin")
	public void faceLogin(HttpServletResponse response,HttpSession session,HttpServletRequest request,@RequestParam("base") String base){
		JsonObject json = new JsonObject();
		json.addProperty("message","");
		List<UserInfo> users = userInfoService.getAllUserInfos();
		for(UserInfo u : users){
			if(u.getUserFacePath() != null && (!u.getUserFacePath().trim().equals(""))){
				String base1 = this.getImageStr(u.getUserFacePath());
				FaceClient faceClient = FaceClient.getInstance(Common.APP_ID,Common.API_KEY, Common.SECRET_KEY);
				boolean login = faceClient.faceContrast(base, base1);
				if(login){
					json.addProperty("message", "登录成功");
					session.setAttribute("loginUser", u);
					break;
				}
			}
		}
		this.writeJson(json.toString(), response);
		
	}
	
	public void writeJson(String json,HttpServletResponse response){
		PrintWriter out =null;
		try {
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			out.print(json);
			//out.write();
			out.flush();
			out.close();
		} catch (Exception e) {
			if(out!=null){
				out.close();
			}
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
		}
	}
	
	/**
	 * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
	 * @param imgFile
	 * @return
	 */
	public  String getImageStr(String imgFile)  {
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e) {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        Base64 encoder = new Base64();  
        return Base64.encodeBase64String(data);//返回Base64编码过的字节数组字符串  
    } 
}
