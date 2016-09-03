package com.chenxun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：chenxun 
 * 创建时间：2016年5月12日 下午11:16:44 
 * 参考： 
 * 说明：
 */
@RestController
public class Application {

	@RequestMapping("/string")
	public String returnString() {
		String nowtime = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时mm 分 ss 秒").format(new Date());
		return "现在时间：" + nowtime;
	}
	
	@RequestMapping("/int")
	public Integer returnInteger() {
		return 100;
	}
	@RequestMapping("/map")
	public Map<Integer, String> returnMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "value1");
		map.put(2, "value2");
		return map;
	}
	@RequestMapping("/list")
	public List<String> returnList() {
		List<String> list = new ArrayList<String>();
		list.add("elemnet1");
		list.add("elemnet2");
		return list;
	}
	@RequestMapping("/bean")
	public Person returnBean() {
		Person p = new Person(1,"Jim");
		return p;
	}
	@RequestMapping("/listBean")
	public List<Person> returnListbean() {
		List<Person> list = new ArrayList<Person>();
		Person p = new Person(1,"Jim");
        list.add(p);
		return list;
	}
	
	class Person{
		private Integer id;
		private String name;
		
		public Person(Integer id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
}
