package com.qsy.ssm.goodscar.controller;





import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qsy.ssm.model.Product;
import com.qsy.ssm.service.IGoodsCarService;
import com.qsy.ssm.shopcar.Shopcar;




@Controller
@RequestMapping("/shopcar")
public class GoodsCarController {
	
	@Autowired
	private IGoodsCarService goodsCarService;
	
	@RequestMapping(value="/add",produces="application/json;charset=utf-8")
	@ResponseBody
	public String addGoods(@RequestParam Integer product_id,@RequestParam Integer count,HttpServletRequest request,HttpServletResponse response){
		String parameter = request.getParameter("callback");
		Cookie[] cookies = request.getCookies();
		int munber =0;
		if(cookies!=null){
			for(Cookie cookie :cookies){
				if(cookie.getName().equals("shopcar_"+product_id)){
					String value = cookie.getValue();
					int parseInt = Integer.parseInt(value);
					int newValue = parseInt+count;
					/*Cookie newcokie = new Cookie("shopcar_"+product_id, newValue+"");
					System.out.println("11--"+value+":"+newValue+"----"+count);
					newcokie.setPath("/");
					newcokie.setMaxAge(365 * 24 * 60 * 60);*/
					cookie.setValue(newValue+"");
					cookie.setPath("/");
					cookie.setMaxAge(24 * 60 * 60);
					System.out.println("11--"+value+":"+newValue+"----"+count+cookie.getName());
					response.addCookie(cookie);
				}
				if(!cookie.getName().equals("shopcar_"+product_id)){
					Cookie cookie2 = new Cookie("shopcar_"+product_id,count+"");
					cookie2.setPath("/");
					cookie2.setMaxAge(24 * 60 * 60);
					munber++;
					response.addCookie(cookie2);
					
				}
			}
			
		}
		
		return parameter+"("+munber+")";
	}
	
	@RequestMapping("/getlist")
	public String getShopCarList(HttpServletRequest request,Model model){
		Cookie[] cookies = request.getCookies();
		List<String> list = new ArrayList<>();
		List<Shopcar> shopcars = new ArrayList<>();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().split("_")[0].equals("shopcar")){
					list.add(cookie.getName().split("_")[1]+":"+cookie.getValue());
				}
			}
		}
		for (String string : list) {
			int id=Integer.parseInt(string.split(":")[0]);
			int count= Integer.parseInt(string.split(":")[1]);
			Product proToShopCar = goodsCarService.addProToShopCar(id);
			Shopcar shopcar = new Shopcar();
			shopcar.setProduct(proToShopCar);
			shopcar.setCount(count);
			shopcars.add(shopcar);
		}
		model.addAttribute("shopcars", shopcars);
		return "flow";
	}
}
