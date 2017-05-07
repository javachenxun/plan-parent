package com.chenxun.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chenxun.utils.HttpClientExcuter;
import com.chenxun.web.service.entity.Person;

/**
 * Created by chenxun on 2016/9/3 11:07
 */
@RestController
@RequestMapping(value = "/test/reciver",
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE
)
public class TestReciverService {
    /**
     * 也可以是使用Map 接收参数
     * @param person
     * @return
     */
    @RequestMapping
    public ResponseEntity<String> confirmResult(@RequestBody Person person) {
        /**
         * result 可以添加一些双方约定的status，message，签名，等等
         */
        Map<String, Object> result = new HashMap<>();
        result.put("id", person.getId());
        result.put("name", person.getName());
        return HttpClientExcuter.writeResponse(result);
    }
}
