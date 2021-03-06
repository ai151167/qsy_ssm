package com.qsy.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.service.ISysUserService;

@Controller
@RequestMapping("sysUser")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;
	
	@RequestMapping("/tologin")
	public String tologin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(SysUser sysUser,Model model){
	   SysUser returnUser = sysUserService.checkIsOk(sysUser);
	    if(returnUser!=null&&returnUser.getAdmin()==true){
	    	return "home";
	    }
	    model.addAttribute("msg", "账户或密码错误!");
		return "login";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String HttpClientTest(HttpServletRequest request){
		String username = request.getParameter("username");
		String age = request.getParameter("age");
		System.out.println("username:"+username+"age:"+age);
		return "ok";
	}
}
