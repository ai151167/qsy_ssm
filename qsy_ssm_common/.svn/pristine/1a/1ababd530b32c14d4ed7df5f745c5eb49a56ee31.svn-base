package com.qsy.httpclient.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class HttpClientTest {
	
	@Test
	public void httpClientTest_1() throws ClientProtocolException, IOException{
		//1、创建HttpClient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//2.定义资源路径
		String path = "https://www.baidu.com";
		//3.使用Get去请求（或POST）
		HttpGet get = new HttpGet(path);
		//4.执行请求
		CloseableHttpResponse response = client.execute(get);
		//5.返回执行结果
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200){
			HttpEntity entity = response.getEntity();
			InputStream inputStream = entity.getContent();//获取响应流
			byte[] bs = new byte[1024];
			int len;
			while((len = inputStream.read(bs))!=-1){
				System.out.println(new String(bs, 0, len));
			}
		}else {
			System.out.println(statusCode);
		}
	}
	
	@Test
	public void HttpClientTest_02() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		String path = "https://www.baidu.com";
		URIBuilder builder = new URIBuilder(path);
		builder.addParameter("username", "aass");
		builder.addParameter("age", "18");
		URI uri = builder.build();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = client.execute(get);
		int code = response.getStatusLine().getStatusCode();
		if(code==200){
			InputStream inputStream = response.getEntity().getContent();
			byte[] bs = new byte[1024];
			int len;
			while((len=inputStream.read(bs))!=-1){
				System.out.println(new String(bs,0,len));
			}
		}else{
			System.out.println(code);
		}
	}
}
