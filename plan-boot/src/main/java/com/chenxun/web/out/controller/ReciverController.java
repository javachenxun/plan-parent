package com.chenxun.web.out.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenxun.component.httpclient.HttpClientExcuter;
import com.chenxun.web.out.domain.Person;

/** 
 * @author：chenxun
 * 创建时间：2016年9月3日 下午11:07:44 
 * 参考：
 * 说明：
 */
@RestController
@RequestMapping(
		value = "/test/reciver", 
		consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,//请求为json数据
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE//响应为json数据
		)
public class ReciverController {
	/**
	 * 也可以是使用Map 接收参数
	 * @param p
	 * @return
	 */
	@RequestMapping
    public ResponseEntity<String> confirmResult(@RequestBody Person p) {
        /**
         * result 可以添加一些双方约定的status，message，签名，等等
         */
        Map<String,Object> result = new HashMap<>();
        result.put("id",  p.getId());
        result.put("name", p.getName());
        return HttpClientExcuter.writeResponse(result);
    }
}
