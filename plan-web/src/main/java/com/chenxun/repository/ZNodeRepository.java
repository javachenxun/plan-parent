package com.chenxun.repository;

import com.chenxun.repository.dao.ZNodeDao;
import com.chenxun.repository.po.ZNodePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenxun on 2017/4/30 10:11
 */
@Repository
public class ZNodeRepository {

    @Autowired
    private ZNodeDao zNodeDao;

    public List<ZNodePO> getAll() {
        return  zNodeDao.getAll();
    }

    public void add(Integer pId, String name) {
        ZNodePO zNodePO = new ZNodePO();
        zNodePO.setName("node14");
        zNodePO.setpId(pId);
        zNodePO.setId(5);
        zNodeDao.add(zNodePO);
    }
}
