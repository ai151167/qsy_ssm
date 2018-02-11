package com.qsy.ssm.searchhandler;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsy.ssm.service.impl.SearchServiceImpl;

public class ListenSearch {
	
	@Autowired
	private SearchServiceImpl searchService;
	
	public void messagerHandler(String msg){
		searchService.synDataByJson(msg);
	}
	
	public void delByIdmessagerHandler(Integer delId){
		searchService.delSearchById(delId);
	}
	public void deletemessagerHandler(String ids){
		searchService.delSearchByJson(ids);
	}
}
