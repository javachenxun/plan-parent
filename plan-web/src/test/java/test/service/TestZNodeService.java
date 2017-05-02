package test.service;


import com.alibaba.fastjson.JSON;
import com.chenxun.repository.po.ZNodePO;
import com.chenxun.service.ZNodeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.TestBase;

import java.util.List;

public class TestZNodeService extends TestBase {

	@Autowired
	private ZNodeService zNodeService;

	@Test
	public void getByIdExchange() {
        List<ZNodePO> all = zNodeService.getAll();
		System.out.println(JSON.toJSONString(all));;
	}
}
