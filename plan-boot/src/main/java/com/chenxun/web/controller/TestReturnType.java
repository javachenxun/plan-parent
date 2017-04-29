package com.chenxun.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chenxun.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Created by chenxun on 2016/5/12 11:16
 */
@RestController
public class TestReturnType {

    @RequestMapping("/string")
    public String returnString() {
        final  String pattern = "yyyy 年 MM 月 dd 日 HH 时mm 分 ss 秒";
        return "now：" + new SimpleDateFormat(Constants.Time.YYYYMMDDHHMMSS).format(new Date());
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
        Person p = new Person(1, "Jim");
        return p;
    }

    @RequestMapping("/listBean")
    public List<Person> returnListbean() {
        List<Person> list = new ArrayList<Person>();
        Person p = new Person(1, "Jim");
        list.add(p);
        return list;
    }

    class Person {
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
