package com.qsy.ssm.service.impl;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.qsy.ssm.mapper.ProductDescMapper;
import com.qsy.ssm.mapper.ProductMapper;
import com.qsy.ssm.model.Product;
import com.qsy.ssm.model.ProductDesc;
import com.qsy.ssm.model.ProductDescExample;
import com.qsy.ssm.service.IDetailService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class DetailServiceImpl implements IDetailService,ServletContextAware {

	@Autowired
	private  FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductDescMapper productDescMapper;

	private ServletContext servletContext;
	
	@Override
	public void createStaticPage(Integer productId) {
		Configuration configuration = this.freeMarkerConfigurer.getConfiguration();
		Writer out =null;
		try {
			Template template = configuration.getTemplate("goods.ftl");
			Map<String , Object> root =new HashMap<>();
			Product product = productMapper.selectByPrimaryKey(productId);
			ProductDescExample example = new ProductDescExample();
			example.createCriteria().andProductIdEqualTo(productId);
			List<ProductDesc> bloBs = productDescMapper.selectByExampleWithBLOBs(example);
			if(bloBs.size()!=0){
				root.put("productDesc", bloBs.get(0).getProductDesc());
			}else {
				root.put("productDesc","暂无描述");
			}
			root.put("contextPath", this.servletContext.getContextPath());
			root.put("product", product);
			String file =servletContext.getRealPath("/goods/"+productId+".html");
			out = new FileWriter(file);
			template.process(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}finally {
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}
