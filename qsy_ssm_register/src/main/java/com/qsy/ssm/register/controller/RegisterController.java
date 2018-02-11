package com.qsy.ssm.register.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsy.ssm.code.SMSCode;
import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.register.service.IRegisterService;
import com.qsy.ssm.sms.IndustrySMS;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IRegisterService registerService;
	
	@RequestMapping("show")
	public String show(){
		return "register";
	}
	
	@RequestMapping("/add")
	public String add(SysUser user){
		SysUser newUser = registerService.add(user);
		return "register";
	}
	
	@RequestMapping("/activate/{uuid}")
	public String activate(@PathVariable String uuid){
		registerService.activate(uuid);
		return "success";
	}
	
	@RequestMapping("/getsmscode/{phonenum}")
	@ResponseBody
	public String checkCode(@PathVariable String phonenum){
		 SMSCode smsCode =IndustrySMS.sendSMS(phonenum, "123456");
		 if("00000".equals(smsCode.getRespCode())){
			 return "ok";
		 }
		return "error";
	}
}
