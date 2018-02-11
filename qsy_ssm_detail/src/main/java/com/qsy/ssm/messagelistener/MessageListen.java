package com.qsy.ssm.messagelistener;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsy.ssm.service.impl.DetailServiceImpl;

public class MessageListen {
	
	@Autowired
	private  DetailServiceImpl detailServiceImpl;
	
	public void messageHandler(Integer id){
		detailServiceImpl.createStaticPage(id);
	}
}
