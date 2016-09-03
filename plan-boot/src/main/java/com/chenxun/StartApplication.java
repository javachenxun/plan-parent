package com.chenxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author：chenxun 
 * 创建时间：2016年5月12日 下午11:16:44 
 * 参考： 
 * 说明：
 */
@EnableAutoConfiguration
@ComponentScan
public class StartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		System.out.println("启动成功");
	}
}
