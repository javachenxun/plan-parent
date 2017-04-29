package com.chenxun.web.service.entity;

/**
 * Created by chenxun on 2016/9/4 1:37
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
