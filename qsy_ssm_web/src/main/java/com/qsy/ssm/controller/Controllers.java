package com.qsy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.qsy.ssm.category.CategoryNode;
import com.qsy.ssm.model.ProductCategory;
import com.qsy.ssm.service.IProductCategoryService;


@Controller
@RequestMapping("/productCategory")
public class Controllers {
	
	@Autowired
	private IProductCategoryService productCategoryService;
	
	@RequestMapping("/list/{pid}")
	@ResponseBody
	public List<ProductCategory> queryByPid(@PathVariable Integer pid){
		return productCategoryService.queryByPid(pid);
	}
	
	@RequestMapping(value="/listAll/{pid}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String listAll(@PathVariable Integer pid){
		 List<CategoryNode> list = productCategoryService.listAll(pid);
		 Gson gson = new Gson();
		 String json = gson.toJson(list);
		 return json;
	}
	
	@RequestMapping(value ="/listJsonp/{pid}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String listJsonp(@PathVariable Integer pid,HttpServletRequest request){
		String parameter = request.getParameter("callback");
		List<CategoryNode> list = productCategoryService.listAll(pid);
		 Gson gson = new Gson();
		 String all = gson.toJson(list);
		return parameter+"("+all+")";
	}
}
