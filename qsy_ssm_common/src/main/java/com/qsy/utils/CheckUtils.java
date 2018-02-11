package com.qsy.utils;

public class CheckUtils {
	public static boolean isEmpty(String str){
		if(str==null&&("").equals(str)){
			return true;
		}
		return false;
	}
}
