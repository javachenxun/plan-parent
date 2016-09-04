package com.chenxun.web.out.service;

import java.io.IOException;

import org.junit.Test;

import com.chenxun.component.httpclient.HttpClientExcuter;
import com.chenxun.web.out.domain.Person;

/** 
 * @author：chenxun
 * 创建时间：2016年9月3日 下午11:52:21 
 * 参考：http://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html
 * 说明：
 */
public class SendService {
	
	@Test
	public void TestSend(){
		String url = "http://192.168.1.102:8080/test/reciver";//必须添加http://  格式要求
		try {
			String sendRequest = HttpClientExcuter.sendRequest(url , new Person());
			System.out.println(sendRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
