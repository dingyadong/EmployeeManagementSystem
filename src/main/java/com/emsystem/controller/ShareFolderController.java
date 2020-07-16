package com.emsystem.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emsystem.pojo.File;
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
		
		List<File> userList = new ArrayList<File>();

		json.setData(userList);
        return json;
    }
}
