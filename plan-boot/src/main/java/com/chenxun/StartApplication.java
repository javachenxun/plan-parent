package com.chenxun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by chenxun on 2016/5/12 11:16
 */
@EnableAutoConfiguration
@ComponentScan
public class StartApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
		System.out.println("启动成功");
	}
}
