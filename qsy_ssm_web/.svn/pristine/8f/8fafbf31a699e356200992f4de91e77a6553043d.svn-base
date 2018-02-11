package com.qsy.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qsy.ssm.service.ImageService;

@Controller
@RequestMapping("/images")
public class ImagesController {
	
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/show")
	public String toImages(){
		return "images/images";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file){
		String path = imageService.upload(file);
		return path;
	}
}
