package com.xyx.shiro;

import com.xyx.shiro.model.entity.User;
import com.xyx.shiro.util.MyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroApplicationTests {
	@Autowired
	private MyMapper<User> myMapper;
	@Test
	public void contextLoads() {
		List<User> users=myMapper.selectAll();
	}
}
