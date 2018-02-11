package com.qsy.ssm.service.impl;

import java.io.File;
import java.io.IOException;

import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qsy.ssm.service.ImageService;
import com.qsy.utils.UploadImagesUtils;

@Service
public class ImageServiceImpl implements ImageService {

	@Value("${default_base_path}")
	private String default_base_path;
	
	@Override
	public String upload(MultipartFile file) {
		String path = null;
		try {
			UploadImagesUtils utils = new UploadImagesUtils("classpath:properties/fastdfs.properties");
			String filepath = file.getOriginalFilename();
			String filesuffix = filepath.substring(filepath.lastIndexOf(".")+1);
			path = utils.imagesUpload(file.getBytes(), filesuffix);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return default_base_path+File.separator+path;
	}

}
