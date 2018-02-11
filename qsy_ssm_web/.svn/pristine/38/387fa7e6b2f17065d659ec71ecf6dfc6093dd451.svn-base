package com.qsy.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsy.ssm.category.CategoryNode;
import com.qsy.ssm.mapper.ProductCategoryMapper;
import com.qsy.ssm.model.ProductCategory;
import com.qsy.ssm.model.ProductCategoryExample;
import com.qsy.ssm.model.ProductCategoryExample.Criteria;
import com.qsy.ssm.service.IProductCategoryService;



@Service("productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private ProductCategoryMapper productCategoryMapper ;
	
	@Override
	public List<ProductCategory> queryByPid(Integer pid) {
		ProductCategoryExample example = new ProductCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		criteria.andFlagEqualTo(true);
		return productCategoryMapper.selectByExample(example);
	}

	@Override
	public List<CategoryNode> listAll(Integer pid) {
		List<ProductCategory> sourcelist = queryByPid(pid);
		List<CategoryNode> targetList = new ArrayList<>();
		for(int i=0;i<sourcelist.size();i++){
			CategoryNode node = new CategoryNode();
			node.setName(sourcelist.get(i).getName());
			node.setId(sourcelist.get(i).getId());
			
			if(sourcelist.get(i).getParent()){
				node.setChildren(listAll(sourcelist.get(i).getId()));
			}
			if(node!=null){
				targetList.add(node);
			}
		
		}
		return targetList;
	}

}
