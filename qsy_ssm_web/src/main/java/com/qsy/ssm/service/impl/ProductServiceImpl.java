package com.qsy.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.qsy.ssm.mapper.ProductDescMapper;
import com.qsy.ssm.mapper.ProductMapper;
import com.qsy.ssm.model.Product;
import com.qsy.ssm.model.ProductDesc;
import com.qsy.ssm.model.ProductDescExample;
import com.qsy.ssm.model.ProductExample;
import com.qsy.ssm.service.IProductService;
import com.qsy.ssm.vo.ProductVO;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductDescMapper productDescMapper;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Override
	public List<Product> getProInfiList() {
		ProductExample example = new ProductExample();
		example.createCriteria().andFlagEqualTo(true);
		return productMapper.selectByExample(example);
	}

	@Override
	public void delSinglePro(Integer id) {
		Product product = new Product();
		product.setId(id);
		product.setFlag(false);
		productMapper.updateByPrimaryKeySelective(product);
		//delByIdSynData(product);
	}


	@Override
	public ProductVO SingleProById(Integer id) {
		ProductVO productVO = new ProductVO();

		ProductExample example = new ProductExample();
		example.createCriteria().andIdEqualTo(id).andFlagEqualTo(true);
		List<Product> list = productMapper.selectByExample(example);

		ProductDescExample exampleDesc = new ProductDescExample();
		exampleDesc.createCriteria().andProductIdEqualTo(id);
		List<ProductDesc> bloBs = productDescMapper.selectByExampleWithBLOBs(exampleDesc);
		if (bloBs != null && !bloBs.isEmpty()) {
			productVO.setProductDesc(bloBs.get(0).getProductDesc());
		}
		if (list != null && !list.isEmpty()) {
			productVO.setProduct(list.get(0));
		}
		return productVO;
	}

	@Override
	public void addPro(Product product, ProductDesc productDesc) {
		product.setFlag(true);
		productMapper.insertSelective(product);
		productDesc.setProductId(product.getId());
		productDescMapper.insert(productDesc);
		// HttpClientUtils.doPost(url, param);传ID
		//synData(product);
	}



	/*
	 * private void synData(Product product) { Gson gson = new Gson(); String
	 * json = gson.toJson(product);
	 * HttpClientUtils.doPostJson("http://localhost:8087/search/synDataByJson",
	 * json);
	 * HttpClientUtils.doPost("http://localhost:8085/detail/createStaticPage/"+
	 * product.getId()); }
	 */

	@Override
	public void updatePro(ProductVO productVo) {
		Product product = productVo.getProduct();
		ProductDesc productDesc = new ProductDesc();

		ProductExample example = new ProductExample();
		example.createCriteria().andIdEqualTo(product.getId()).andFlagEqualTo(true);
		productMapper.updateByExampleSelective(product, example);

		//synData(product);

		productDesc.setProductId(product.getId());
		productDesc.setProductDesc(productVo.getProductDesc());
		ProductDescExample exampleDesc = new ProductDescExample();
		exampleDesc.createCriteria().andProductIdEqualTo(product.getId());
		productDescMapper.updateByExampleSelective(productDesc, exampleDesc);
	}

	@Override
	public void delAllPro(String ids) {
		String[] split = ids.split(",");
		List<Integer> idList = new ArrayList<>();
		for (int i = 0; i < split.length; i++) {
			int id = Integer.parseInt(split[i]);
			idList.add(id);
		}
		Product product = new Product();
		product.setFlag(false);
		ProductExample example = new ProductExample();
		example.createCriteria().andIdIn(idList);
		productMapper.updateByExampleSelective(product, example);
		//delSynData(ids);
	}
	
	private void delByIdSynData(Product product) {
		amqpTemplate.convertAndSend("delById", product.getId());
	}

	
	private void delSynData(String ids) {
		amqpTemplate.convertAndSend("delete", ids);
	}

	private void synData(Product savePro) {
		Gson gson = new Gson();
		String json = gson.toJson(savePro);
		amqpTemplate.convertAndSend("search", json);
		amqpTemplate.convertAndSend("detail",savePro.getId());
	}
}
