package com.chenxun.web.out.domain;
/** 
 * @author：chenxun
 * 创建时间：2016年9月4日 下午1:37:37 
 * 参考：
 * 说明：
 */
public class Person {
	private Long id = 1L;
	private String name = "陈浚";
	
	public Person() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
