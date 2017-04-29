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
		Person name1 = new Person(1, 20, "name1");
		Person name2 = new Person(2, 25, "name2");
		Person name3 = new Person(2, 30,"name3");
		list.add(name1);
		list.add(name2);
		list.add(name3);
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
