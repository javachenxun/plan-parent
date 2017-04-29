package com.chenxun.httpclient;


import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.UUID;

import javax.net.ssl.SSLContext;

import com.chenxun.utils.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

/** 
 * @author：chenxun
 * 创建时间：2016年9月3日 下午10:49:17 
 * 参考：
 * 请求使用纯httpclient类，响应结合springmvc个别类
 * 
 */
public class HttpClientExcuter {

	private static Logger LOG = LoggerFactory.getLogger(HttpClientExcuter.class);
	private static HttpClientBuilder httpClientBuilder = null;
	private final static int timeout = 6000;
	
	//自定义添加了SSLContext的创建即为创建https ,(默认的即为http)
	static {
			try {
				SSLContextBuilder sslContextBuilder = SSLContextBuilder.create();
				sslContextBuilder.loadTrustMaterial(new TrustStrategy() {
	                //信任所有
					@Override
					public boolean isTrusted(X509Certificate[] chain,String authType) {
						return true;
					}
				});
				SSLContext sslContext = sslContextBuilder.build();
				SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
						sslContext, new NoopHostnameVerifier());
				httpClientBuilder = HttpClients.custom().setSSLSocketFactory(sslSocketFactory);
			} catch (Exception e) {
				LOG.error("[ static ]https初始化失败，异常:",e);
				httpClientBuilder = HttpClientBuilder.create();
			}
			Builder custom = RequestConfig.custom();
			custom.setConnectionRequestTimeout(timeout)
			      .setConnectTimeout(timeout)
				  .setSocketTimeout(timeout);
			httpClientBuilder.setDefaultRequestConfig(custom.build());
	}
    
	public static String sendRequest(String url, Object data) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = httpClientBuilder.build();

		HttpPost httpPost = new HttpPost(url);
		long timestamp = System.currentTimeMillis();
		httpPost.addHeader("timestamp", timestamp + "");
		httpPost.setEntity(new StringEntity(toJSONString(data), Constants.CharSet.UTF_8));
		httpPost.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        //response 不需要关闭  可以看下源码
		CloseableHttpResponse response = httpClient.execute(httpPost);
		if (response.getStatusLine() == null || response.getStatusLine().getStatusCode() != 200) {
		    throw new RuntimeException(response.getStatusLine().toString());
		} else {
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity,  Constants.CharSet.UTF_8);
		}
	}
	/**
	 * Response结合springmvc
	 * @param data
	 * @return
	 */
	public static ResponseEntity<String> writeResponse(Object data) {
		long timestamp = System.currentTimeMillis();
		String body = JSON.toJSONString(data);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("timestamp", timestamp + "");
		httpHeaders.add("token", UUID.randomUUID().toString());
		httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);

		return new ResponseEntity<String>(body, httpHeaders, HttpStatus.OK);
	}
	/**
	 * 自定义json序列化  可以处理枚举(但这个例子中未写)
	 * @param object
	 * @return
	 */
	private static String toJSONString(Object object) {
		try{
			SerializeWriter out = new SerializeWriter();
			JSONSerializer serializer = new JSONSerializer(out);
			serializer.write(object);
			return out.toString();
		}catch(Exception e){
			
		}
		return null;
	}
}
