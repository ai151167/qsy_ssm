package com.qsy.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qsy.ssm.model.Product;
import com.qsy.ssm.model.ProductDesc;
import com.qsy.ssm.service.IProductService;
import com.qsy.ssm.vo.ProductVO;


@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "addPro";
	}
	
	@RequestMapping("/addPro")
	@ResponseBody
	public String addPro(ProductVO productVO){
		ProductDesc productDesc = new ProductDesc();
		productDesc.setProductDesc(productVO.getProductDesc());
		productService.addPro(productVO.getProduct(),productDesc);
		return "addOk";
	}
	
	@RequestMapping("list/{pageNum}")
	public String getList(@PathVariable Integer pageNum,Model model){
		PageHelper.startPage(pageNum, 2);
		List<Product> list = productService.getProInfiList();
		PageInfo<Product> pageInfo = new PageInfo<>(list, 3);
		model.addAttribute("pageInfo", pageInfo);
		return "index";
	}
	
	@RequestMapping("/delSinglePro/{id}")
	@ResponseBody
	public String delSinglePro(@PathVariable Integer id){
		productService.delSinglePro(id);
		return "delOk";
	}
	@RequestMapping("/SinglePro/{id}")
	@ResponseBody
	public ProductVO SingleProById(@PathVariable Integer id,Model model){
		ProductVO productVO = productService.SingleProById(id);
		return productVO;
	}
	
	@RequestMapping("/updatePro")
	@ResponseBody
	public String updatePro(ProductVO productVo){
		productService.updatePro(productVo);
		return "updateOk";
	}
	
	@RequestMapping("/delAllPro/{ids}")
	@ResponseBody
	public String delAllPro(@PathVariable String ids){
		productService.delAllPro(ids);
		return "delAllOk";
	}
}
