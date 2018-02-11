package com.qsy.ssm.frontcontroller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/front")
public class FrontController {

	@RequestMapping("index")
	public String toIndex(Model model){
		/*String get = HttpClientUtils.doGet("http://localhost:8080/productCategory/listAll/0");
		Gson gson = new Gson();
		List<CategoryNode> NodeLists = gson.fromJson(get,new TypeToken<List<CategoryNode>>(){}.getType());
		model.addAttribute("NodeLists", NodeLists);*/
		return "index";
	}
	
}
