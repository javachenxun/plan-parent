package com.chenxun.service.impl;

import com.chenxun.repository.ZNodeRepository;
import com.chenxun.repository.po.ZNodePO;
import com.chenxun.service.ZNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenxun on 2017/4/30 10:04
 */
@Service
public class ZNodeServiceImpl implements ZNodeService {

    @Autowired
    private ZNodeRepository zNodeRepository;

    @Override
    public List<ZNodePO> getAll() {
        return zNodeRepository.getAll();
    }

    @Override
    public void add(Integer pId, String name) {
        zNodeRepository.add(pId,name);
    }
}
