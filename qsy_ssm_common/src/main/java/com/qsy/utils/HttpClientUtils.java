package com.qsy.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
	
	public static String doGet(String url,Map<String, String> param){
		String result = "";
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			URIBuilder builder = new URIBuilder(url);
			if(param!=null){
				for (String  key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();
			HttpGet get = new HttpGet(uri);
			response= client.execute(get);
			if(response.getStatusLine().getStatusCode()==200){
				/*InputStream inputStream = response.getEntity().getContent();
				byte[] bs = new byte[1024]
				int len;
				while((len = inputStream.read(bs))!=-1){
					result = new String(bs, 0, len);
				}*/
				result = EntityUtils.toString(response.getEntity(), "utf-8");
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	
	}
	
	public static String doGet(String url){
		return doGet(url, null);
	}
	public static String doPost(String url,Map<String, String> param){
		String result="";
		
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			
			HttpPost post = new HttpPost(url);
			List<NameValuePair> paramList = new ArrayList<>();
			for (String key : param.keySet()) {
				paramList.add(new BasicNameValuePair(key, param.get(key)));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
			post.setEntity(entity);
			response = client.execute(post);
			result = EntityUtils.toString(entity, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static String doPost(String url){
		return doPost(url, null);
	}

	public static String doPostJson(String url,String json){
		String result = "";
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		
		try {
			HttpPost post = new HttpPost(url);
			StringEntity entity = new StringEntity(json,ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			response = client.execute(post);
			result = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(response!=null){
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
}
