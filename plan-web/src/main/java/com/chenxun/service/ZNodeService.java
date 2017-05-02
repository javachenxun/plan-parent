package com.chenxun.service;

import com.chenxun.repository.po.ZNodePO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenxun on 2017/4/30 10:03
 */
public interface ZNodeService {
    List<ZNodePO> getAll();

    void add(Integer pId, String name);
}
