package com.qsy.ssm.service;

import java.util.List;

import com.qsy.ssm.category.CategoryNode;
import com.qsy.ssm.model.ProductCategory;


public interface IProductCategoryService {

	List<ProductCategory> queryByPid(Integer pid);

	List<CategoryNode>  listAll(Integer pid);

}
