package com.chinasofti.ssm01.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ����Controller�ĸ��࣬�ṩ�˷�ҳ��Ϣ 
 * @author Administrator
 *
 */
public class BaseController { 
	/**
	 * ��ʼ��¼��
	 */
	private int pageNo = 0;
	/**
	 * �ܼ�¼��
	 */
	private long total;
	/**
	 * ÿҳ��ʾ�ļ�¼��
	 */
	public final static int PAGE_NUM = 2;
	
	private String result = "ϵͳæ�����Ժ����ԣ�";
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	/**
	 * ��ʼ����ҳ��Ϣ
	 */
	public void initPage(HttpServletRequest request){
		String page_str = request.getParameter("pager.offset");
		if(page_str != null && !page_str.equals("")){
			pageNo = Integer.parseInt(page_str);
		}else{
			pageNo = 0;
		}
	}
	
}
