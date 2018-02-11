package com.qsy.ssm.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.qsy.ssm.mapper.ProductMapper;
import com.qsy.ssm.model.Product;
import com.qsy.ssm.model.ProductExample;
import com.qsy.ssm.page.SearchPageInfo;
import com.qsy.ssm.service.ISearchService;

@Service
public class SearchServiceImpl implements ISearchService {

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private CloudSolrServer solrServer;
	// private HttpSolrServer solrServer;

	@Override
	public String synAllData() {
		ProductExample example = new ProductExample();
		example.createCriteria().andFlagEqualTo(true);
		List<Product> list = productMapper.selectByExample(example);

		for (Product product : list) {
			SolrInputDocument document = new SolrInputDocument();
			document.setField("id", product.getId());
			document.setField("product_name", product.getName());
			document.setField("product_price", product.getPrice());
			document.setField("sale_point", product.getSalePoint());
			document.setField("images", product.getImages());

			try {
				solrServer.add(document);
			} catch (SolrServerException | IOException e) {
				e.printStackTrace();
				return "error";
			}
		}
		try {
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	@Override
	public List<Product> searchSelect(String selectInfo) {
		List<Product> proList = new ArrayList<>();
		SolrQuery query = new SolrQuery();
		QueryResponse response = null;
		if (StringUtils.isEmpty(selectInfo)) {
			query.setQuery("*:*");
		} else {
			query.setQuery("product_keywords:" + selectInfo);
		}
		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");

		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		SolrDocumentList list = response.getResults();
		Map<String, Map<String, List<String>>> map = response.getHighlighting();
		if (list.size() != 0) {
			for (SolrDocument doc : list) {
				Product product = new Product();
				product.setId(Integer.parseInt(doc.getFieldValue("id").toString()));
				// product.setName(doc.getFieldValue("product_name").toString());
				product.setPrice(Integer.parseInt(doc.getFieldValue("product_price").toString()));
				product.setSalePoint(doc.getFieldValue("sale_point").toString());
				product.setImages(doc.getFieldValue("images").toString());

				List<String> name = map.get(doc.getFieldValue("id")).get("product_name");
				if (name.size() != 0) {
					product.setName(name.get(0));
				}
				proList.add(product);
			}
		}
		return proList;
	}

	@Override
	public SearchPageInfo<Product> searchToPage(String selectInfo, Integer pageIndex, int size) {
		SearchPageInfo<Product> pageInfo = new SearchPageInfo<>();
		pageInfo.setPageNum(pageIndex);
		pageInfo.setPageSize(size);

		List<Product> proList = new ArrayList<>();
		SolrQuery query = new SolrQuery();
		QueryResponse response = null;
		if (StringUtils.isEmpty(selectInfo)) {
			query.setQuery("product_keywords:*");
		} else {
			query.setQuery("product_keywords:" + selectInfo);
		}
		query.setHighlight(true);
		query.addHighlightField("product_name");
		query.addHighlightField("sale_point");
		query.setHighlightSimplePre("<font color='red'>");
		query.setHighlightSimplePost("</font>");
		query.setStart((pageIndex - 1) * size);
		query.setRows(size);
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		SolrDocumentList list = response.getResults();
		if (list.size() != 0) {
			long total = list.getNumFound();
			Map<String, Map<String, List<String>>> map = response.getHighlighting();
			for (SolrDocument doc : list) {
				Product product = new Product();
				product.setId(Integer.parseInt(doc.getFieldValue("id").toString()));
				// product.setName(doc.getFieldValue("product_name").toString());
				product.setPrice(Integer.parseInt(doc.getFieldValue("product_price").toString()));
				//product.setSalePoint(doc.getFieldValue("sale_point").toString());
				product.setImages(doc.getFieldValue("images").toString());

				List<String> nameList = map.get(doc.getFieldValue("id")).get("product_name");
				
				if (nameList !=null) {
					product.setName(nameList.get(0));
				} else {
					product.setName(doc.getFieldValue("product_name").toString());
				}
				List<String> pointList = map.get(doc.getFieldValue("id")).get("sale_point");
				if (pointList !=null) {
					product.setSalePoint(pointList.get(0));
				} else {
					product.setSalePoint(doc.getFieldValue("sale_point").toString());
				}
				proList.add(product);
			}
			pageInfo.setTotal(total);
			pageInfo.setPages((int) (total % size == 0 ? total / size : total / size + 1));
			pageInfo.setList(proList);
		}
		return pageInfo;
	}

	@Override
	public String synDataByJson(String json) {
		Gson gson = new Gson();
		Product product = gson.fromJson(json, Product.class);

		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", product.getId());
		document.setField("product_name", product.getName());
		document.setField("product_price", product.getPrice());
		document.setField("sale_point", product.getSalePoint());
		document.setField("images", product.getImages());

		try {
			solrServer.add(document);
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "error";
		}

		try {
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	@Override
	public void delSearchById(Integer productId) {
		try {
			solrServer.deleteById(productId.toString());
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delSearchByJson(String json) {
		
		try {
			String[] split = json.split(",");
			List<String> list = new ArrayList<>();
			for (int i=0;i<split.length;i++) {
				list.add(split[i]);
			}
			solrServer.deleteById(list);
			solrServer.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
