package com.qsy.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("background")
public class welcomeController {

	@RequestMapping("welcome")
	public String welcome(){
		return "welcome";
	}
	
	
	@RequestMapping("home")
	public String home(){
		return "home";
	}
}
