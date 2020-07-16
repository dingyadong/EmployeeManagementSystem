package com.emsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.emsystem.dao.CardHolderDao;
import com.emsystem.pojo.CardHolder;
import com.emsystem.service.CardHolderService;

public class CardHolderServiceImpl implements CardHolderService{
@Autowired CardHolderDao dao;
	@Override
	public List<CardHolder> cardHolderList() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}

}
