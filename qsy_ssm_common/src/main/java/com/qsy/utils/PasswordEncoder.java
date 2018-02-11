package com.qsy.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordEncoder {
	public static final Md5PasswordEncoder ENCODER = new Md5PasswordEncoder();
	public static final String SALT = "qsy";
	
	public static String encodePassword(String password,String salt){
		return ENCODER.encodePassword(password, salt);
	}
	
	public static boolean  isPasswordInvalid(String encPass,String rawPass,String salt){
		return ENCODER.isPasswordValid(encPass, rawPass, salt);
	}
}
