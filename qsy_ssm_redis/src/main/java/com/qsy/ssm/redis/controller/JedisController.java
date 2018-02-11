package com.qsy.ssm.redis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import redis.clients.jedis.JedisCluster;

@Controller
@RequestMapping("/jedis")
public class JedisController {
	
	@Autowired
	private JedisCluster jedisCluster;
	
	
	@RequestMapping("/set")
	@ResponseBody
	public String set(@RequestParam String key,@RequestParam String value,@RequestParam String seconds){
		 String result = jedisCluster.set(key, value);
		 if(seconds != null){
			 jedisCluster.expire(key, Integer.parseInt(seconds));
		 }
		 return result;
	}
	
	@RequestMapping(value="/get/{key}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String get(@PathVariable String key,HttpServletRequest request){
		String parameter = request.getParameter("callback");
		String result = jedisCluster.get(key);
		Gson gson = new Gson();
		String json = gson.toJson(result);
		return parameter+"("+json+")";
	}
	@RequestMapping(value="/del/{key}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String del(@PathVariable String key,HttpServletRequest request){
		String parameter = request.getParameter("callback");
		Long del = jedisCluster.del(key);
		Gson gson = new Gson();
		String json = gson.toJson("ok");
		return parameter+"("+json+")";
	}
}
