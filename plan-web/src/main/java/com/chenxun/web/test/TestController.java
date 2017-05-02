package com.chenxun.web.test;

import com.chenxun.web.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chenxun on 2017/4/30 1:41
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "test/index";
    }

    @RequestMapping("/list")
    public String index(ModelMap model) {
        model.put("users", Person.getList());
        return "test/list";
    }
}
