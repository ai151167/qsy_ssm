package com.qsy.ssm.logincontroller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qsy.ssm.model.SysUser;
import com.qsy.ssm.service.ILoginService;
import com.qsy.utils.HttpClientUtils;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	
	@RequestMapping("tologin")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(SysUser user,HttpServletResponse response){
		SysUser sysUser = loginService.loginCheck(user);
		if(sysUser!=null){
			Map<String, String> param = new HashMap<>();
			param.put("key", "sysUser:"+sysUser.getId());
			param.put("value", sysUser.getUsername());
			param.put("seconds", 30*60+"");
			HttpClientUtils.doPost("http://localhost:8086/jedis/set", param);
			Cookie cookie = new Cookie("token_id","sysUser:"+sysUser.getId());
			cookie.setPath("/");
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			return "redirect:http://localhost:8083/front/index";
		}
		return "login";
	}
	
}
