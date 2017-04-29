package com.chenxun.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chenxun.vo.Person;

/** 
 * @author：chenxun
 * 创建时间：2016年7月24日 上午10:26:26 
 * 参考：
 * 说明：
 */
@Controller
@RequestMapping("/velocity")
public class TestController {
	
	@RequestMapping("/index")
	public String index() {
        return "index";
	}
	@RequestMapping("/list")
	public String index(ModelMap model) {
		model.put("users", Person.getList());
		return "list";
	}
}
