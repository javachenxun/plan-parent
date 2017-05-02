package com.chenxun.web.setting;

import com.alibaba.fastjson.JSON;
import com.chenxun.repository.po.ZNodePO;
import com.chenxun.service.ZNodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenxun on 2017/4/30 1:17
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    private final   Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private ZNodeService zNodeService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/url")
    public String url() {
        return "setting/url";
    }

    @RequestMapping(value = "/init", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public @ResponseBody String init() {
        return  JSON.toJSONString(zNodeService.getAll());
    }

    @RequestMapping("/test")
    public String test() {
        return   "setting/test";
    }


    @RequestMapping("/add")
    public @ResponseBody  String add(Integer pId,String name){
        LOG.info("[add] pId={} name={}",pId,name);
        zNodeService.add(pId,name);
        return   "";
    }
}
