package com.qsy.ssm.searchcontroller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsy.ssm.model.Product;
import com.qsy.ssm.page.SearchPageInfo;
import com.qsy.ssm.service.ISearchService;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private ISearchService searchService;
	
	@RequestMapping("/synAllData")
	@ResponseBody
	public String synAllData(){
		return searchService.synAllData();
	}
	
	@RequestMapping("/synDataByJson")
	@ResponseBody
	public String synDataByJson(@RequestBody String json){
		return searchService.synDataByJson(json);
	}
	
	@RequestMapping("/searchSelect/{pageIndex}")
	public String searchSelect(@PathVariable Integer pageIndex,HttpServletRequest request,Model model){
		String selectInfo = request.getParameter("search_content");
		//List<Product> prolist = searchService.searchSelect(selectInfo);
		SearchPageInfo<Product> pageInfo = searchService.searchToPage(selectInfo,pageIndex,4);
		pageInfo.setNavigatePages(3);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("search_content", selectInfo);
		return "list";
	}
	
	@RequestMapping("/searchSelect_ajax/{pageIndex}")
	@ResponseBody
	public SearchPageInfo<Product> searchSelect_ajax(@PathVariable Integer pageIndex,HttpServletRequest request,Model model){
		String selectInfo = request.getParameter("search_content");
		SearchPageInfo<Product> pageInfo = searchService.searchToPage(selectInfo,pageIndex,4);
		pageInfo.setSearchString(selectInfo);
		pageInfo.setNavigatePages(3);
		return pageInfo;
	}
	
	public String delSearchById(Integer productId){
		searchService.delSearchById(productId);
		return null;
	}
	public String delSearchByJson(String json){
		searchService.delSearchByJson(json);
		return null;
	}
}
