package com.emsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.Folder;
import com.emsystem.pojo.ObjectRlationJson;
/*
 * ʵ�ֹ��ܣ������ļ��еĿ�����
 * �ֹ������Ƕ�
 * ���ڣ�2020/7/15
 * 
 */
@Controller
public class ShareFolderController {
	@RequestMapping(value = "/shareFoloderList",produces ={ "application/json;charset=UTF-8"})
    @ResponseBody
    public ObjectRlationJson testjson(){
		ObjectRlationJson json = new ObjectRlationJson();
		
		List<Folder> userList = new ArrayList<Folder>();
		userList.add(new Folder("��1","2020/07/10 11:05:41","��"));
		userList.add(new Folder("��12","2020/07/10 11:05:41","��"));
		userList.add(new Folder("��13","2020/07/10 11:05:41","��"));
		json.setData(userList);
        return json;
    }
}
