package com.chenxun.repository.dao;

import com.chenxun.repository.po.ZNodePO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenxun on 2017/4/30 10:14
 */
@Repository
public interface ZNodeDao {

    @Select("select id,pId,name from db_z_node")
    public List<ZNodePO> getAll();

    @Insert("insert db_z_node values (#{id},#{pId},#{name})")
    public void add(ZNodePO zNodePO);
}
