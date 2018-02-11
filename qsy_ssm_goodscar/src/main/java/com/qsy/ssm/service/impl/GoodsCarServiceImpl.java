package com.qsy.ssm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsy.ssm.mapper.ProductMapper;
import com.qsy.ssm.model.Product;
import com.qsy.ssm.service.IGoodsCarService;

@Service
public class GoodsCarServiceImpl implements IGoodsCarService {

	@Autowired
	private ProductMapper productMapper;
	
	public Product addProToShopCar(Integer product_id) {
		
		return productMapper.selectByPrimaryKey(product_id);
	}

}
