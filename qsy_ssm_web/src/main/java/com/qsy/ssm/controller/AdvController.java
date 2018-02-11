package com.qsy.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.qsy.ssm.model.Advs;
import com.qsy.ssm.service.IAdvServiceImpl;

@Controller
@RequestMapping("/adv")
public class AdvController {
	
	@Autowired
	private IAdvServiceImpl advService;
	
	@RequestMapping("/adv/{pageNum}")
	public String toAdv(@PathVariable Integer pageNum, Model model){
		PageHelper.startPage(pageNum,3);
		List<Advs> advsList =  advService.getListAdv();
		PageInfo<Advs> pageInfo = new PageInfo<>(advsList,3);
		model.addAttribute("pageInfo", pageInfo);
		return "adv";
	}
	
	@RequestMapping("/addAdv")
	@ResponseBody
	public String addAdv(Advs advs){
		advService.addAdv(advs);
		return "addOk";
	}
	
	@RequestMapping("/delSingleAdv/{id}")
	@ResponseBody
	public String delSingleAdv(@PathVariable Integer id){
		advService.delSingleAdv(id);
		return "delOk";
	}
	
	
	@RequestMapping("/delAllAdv/{ids}")
	@ResponseBody
	public String delAllAdv(@PathVariable String ids){
		advService.delAllAdv(ids);
		return "delAllOk";
	}
	
	@RequestMapping("/SingleAdv/{id}")
	@ResponseBody
	public Advs SingleAdv(@PathVariable Integer id){
		return  advService.SingleAdv(id);
	}
	
	@RequestMapping("/updateAdv")
	@ResponseBody
	public String updateAdv(Advs advs){
		advService.updateAdv(advs);
		return "updateOk";
	}
	
	@RequestMapping(value="/advJsonp",produces="application/json;charset=utf-8")
	@ResponseBody
	public String advcJsonp(HttpServletRequest request){
		List<Advs> list =advService.advcJsonp();
		Gson gson = new Gson();
		String gstr = gson.toJson(list);
		String parameter = request.getParameter("callback");
		return parameter+"("+gstr+")";
	}
}
