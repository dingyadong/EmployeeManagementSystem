package com.chinasofti.ssm01.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.ssm01.entity.GoodsInfo;
import com.chinasofti.ssm01.entity.ImgUrl;
import com.chinasofti.ssm01.service.GoodsInfoService;
import com.chinasofti.ssm01.util.BaseController;
import com.chinasofti.ssm01.util.Common;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 鍟嗗搧绠＄悊鐨勬帶鍒跺櫒
 * 
 * @author 
 *
 */
@Controller
@RequestMapping("/goods/")
public class GoodsController extends BaseController{

	@Autowired
	private GoodsInfoService goodsservice;
	/*@Autowired
	private StaticPageService staticPageService;*/


	@RequestMapping("loadadd.do")
	public String loadadd() {
		return "goods_info_add";
	}

	/**
	 * 涓婁紶鍟嗗搧鍥剧墖
	 * 
	 * @param shopimg
	 * @return
	 */
	@RequestMapping("upload.do")
	public @ResponseBody ImgUrl uploadImg(@RequestParam(required = false) MultipartFile shopimg) {

		try {

			// 鍥剧墖鍚嶇О鐢熸垚绛栫暐
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String format = df.format(new Date());
			System.out.println(format);
			Random r = new Random();
			for (int i = 0; i < 3; i++) {
				format += r.nextInt(100);
			}

			// 淇濆瓨鏁版嵁搴撹矾寰�
			String path = "upload/" + format + ".jpg";

			// 鍙﹀涓�鍙版湇鍔″櫒鍦板潃
			String url = Common.IMG_SERVER_URL + path;

			// 瀹炰緥鍖杍ersey
			Client client = new Client();

			// 璁剧疆璇锋眰璺緞
			WebResource resource = client.resource(url);

			resource.put(String.class, shopimg.getBytes());

			ImgUrl iu = new ImgUrl();
			iu.setPath(path);
			iu.setUrl(url);

			return iu;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("uploadfile.do")
	public void uploadfile(@RequestParam(required = false) MultipartFile upload, HttpServletResponse response,HttpServletRequest request) {

		try {
			// 鍥剧墖鍚嶇О鐢熸垚绛栫暐
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String format = df.format(new Date());
			System.out.println(format);
			Random r = new Random();
			for (int i = 0; i < 3; i++) {
				format += r.nextInt(100);
			}

			// 淇濆瓨鏁版嵁搴撹矾寰�
			String path = "upload/" + format + ".jpg";

			// 鍙﹀涓�鍙版湇鍔″櫒鍦板潃
			String url = Common.IMG_SERVER_URL + path;

			// 瀹炰緥鍖杍ersey
			Client client = new Client();

			// 璁剧疆璇锋眰璺緞
			WebResource resource = client.resource(url);

			resource.put(String.class, upload.getBytes());
			
			//鍝嶅簲
			PrintWriter out = response.getWriter();
			//鑾峰彇璺緞
			//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();

			String callback = request.getParameter("CKEditorFuncNum");
			
			out.print("<script>window.parent.CKEDITOR.tools.callFunction("+callback+",'"+url+"') </script>");			
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(GoodsInfo goodsinfo, Model model) {

		String info = "鎿嶄綔澶辫触";
		try {

			if (goodsinfo != null) {
				goodsinfo.setGoodsState(Common.GOODS_STATE_INIT);
			}
			goodsservice.add(goodsinfo);
			info = "鎿嶄綔鎴愬姛";
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("info", info);

		return "index";
	}
	
	/**
	 * 鏌ヨ鍟嗗搧淇℃伅
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(GoodsInfo info,Model model,HttpServletRequest request){
		
		List<Map> list = goodsservice.getlist(info);
		
		model.addAttribute("list", list);
		
		return "goods_info_list";
	}
	
	/**
	 * 鏌ョ湅鍟嗗搧淇℃伅
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("goodsinfo.do")
	public String getInfo(GoodsInfo info,Model model){
		
		Map map = goodsservice.getGoodsInfo(info);
		
		model.addAttribute("goods", map);
		
		return "goods_info_show";
	}
}
