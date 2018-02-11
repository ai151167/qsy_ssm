package com.qsy.ssm.emailmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.google.gson.Gson;
import com.qsy.ssm.model.SysUser;

public class MessageEmail {
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public void listenEmail(String json){
		Gson gson = new Gson();
		SysUser user = gson.fromJson(json, SysUser.class);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("验证激活");
		message.setText("http://localhost:8089/register/activate/"+user.getUseruuid());
		mailSender.send(message);
	}
}
