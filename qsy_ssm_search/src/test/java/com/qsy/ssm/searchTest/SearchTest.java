package com.qsy.ssm.searchTest;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-*.xml")
public class SearchTest {
	
	@Test
	public void saveOrUpdate() throws Exception, IOException{
		//HttpSolrServer solrServer = new HttpSolrServer("http://192.168.136.132:8080/solr");
		CloudSolrServer solrServer = new CloudSolrServer("192.168.136.132:2185,192.168.136.132:2186,192.168.136.132:2187");
		solrServer.setDefaultCollection("collection2");
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", 65);
		doc.addField("product_name", "9999");
		doc.addField("product_price", 888);
		doc.addField("sale_point", "9999");
		doc.addField("images", "http://192.168.136.131\\group1/M00/00/01/wKiIg1nBhamAM4bRAAU_Mqps9QI768.jpg");
		solrServer.add(doc);
		solrServer.commit();
	}
	
	@Test
	public void query() throws Exception{
		//HttpSolrServer solrServer = new HttpSolrServer("http://192.168.136.132:8080/solr");
		CloudSolrServer solrServer = new CloudSolrServer("192.168.136.132:2185,192.168.136.132:2186,192.168.136.132:2187");
		solrServer.setDefaultCollection("collection2");
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList list = response.getResults();
		System.out.println(list.size());
		for (SolrDocument solrDocument : list) {
			System.out.println("id:"+solrDocument.getFieldValue("id"));
			System.out.println("name:"+solrDocument.getFieldValue("product_name"));
		}
	}
	
	@Test
	public void delById() throws Exception, IOException{
		//HttpSolrServer solrServer = new HttpSolrServer("http://192.168.136.132:8080/solr");
		CloudSolrServer solrServer = new CloudSolrServer("192.168.136.132:2185,192.168.136.132:2186,192.168.136.132:2187");
		solrServer.deleteById("55");
		solrServer.commit();
	}
	@Test
	public void delByQuery() throws Exception, IOException{
		//HttpSolrServer solrServer = new HttpSolrServer("http://192.168.136.132:8080/solr");
		CloudSolrServer solrServer = new CloudSolrServer("192.168.136.132:2185,192.168.136.132:2186,192.168.136.132:2187");
		solrServer.deleteByQuery("product_name:99");
		solrServer.commit();
	}
}
