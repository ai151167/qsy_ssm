package com.qsy.ssm.detailcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsy.ssm.service.IDetailService;

@Controller
@RequestMapping("detail")
public class DetailController {

	@Autowired
	private IDetailService detailService;
	
	@RequestMapping("createStaticPage/{productId}")
	@ResponseBody
	public String createStaticPage(@PathVariable Integer productId){
		detailService.createStaticPage(productId);
		return "suuccess";
	}
	
	
}
