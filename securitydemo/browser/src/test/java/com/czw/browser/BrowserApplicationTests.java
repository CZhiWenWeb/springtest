package com.czw.browser;

import com.czw.browser.data.model.entity.User;
import com.czw.browser.data.util.MyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrowserApplicationTests {
	@Autowired
	private MyMapper<User> myMapper;

	@Test
	public void contextLoads() {
		List<User> users = myMapper.selectAll();
	}
}
