package com.chenxun.vo;

import java.util.ArrayList;
import java.util.List;

/** 
 * @author：chenxun
 * 创建时间：2016年7月24日 下午9:34:32 
 * 参考：
 * 说明：
 */
public class Person {  
	
	static List<Person> list= new ArrayList<Person>();
	
	static{
		Person wukong = new Person(1, 20, "悟空");
		Person bajie = new Person(2, 25, "八戒");
		Person shifu = new Person(2, 30,"师傅");
		list.add(wukong);
		list.add(bajie);
		list.add(shifu);
	}
	
	
	public static List<Person> getList() {
		return list;
	}

	private Integer id;
	private Integer userAge;
	private String userName;

	public Person(Integer id, Integer userAge, String userName) {
		this.id = id;
		this.userAge = userAge;
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

  
}
