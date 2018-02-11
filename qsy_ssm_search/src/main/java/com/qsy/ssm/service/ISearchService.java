package com.qsy.ssm.service;

import java.util.List;

import com.qsy.ssm.model.Product;
import com.qsy.ssm.page.SearchPageInfo;

public interface ISearchService {

	String synAllData();

	List<Product> searchSelect(String selectInfo);

	SearchPageInfo<Product> searchToPage(String selectInfo, Integer pageIndex, int size);

	String synDataByJson(String json);

	void delSearchById(Integer productId);

	void delSearchByJson(String json);

}
