package com.chenxun.web.service;

import java.io.IOException;

import org.junit.Test;

import com.chenxun.httpclient.HttpClientExcuter;
import com.chenxun.web.service.entity.Person;

/** 
 * Created by chenxun on 2016/9/3 11:52
 * 参考：http://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html
 */
public class TestSendService {
	
	@Test
	public void send(){
		//必须添加http://  格式要求
		String url = "http://192.168.1.102:8080/test/reciver";
		try {
			String sendRequest = HttpClientExcuter.sendRequest(url , new Person());
			System.out.println(sendRequest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
