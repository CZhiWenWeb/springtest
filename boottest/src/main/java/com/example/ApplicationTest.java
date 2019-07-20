package com.example;

import com.example.bean.Student;
import com.example.service.StudentServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-20 16:15
 * @UpdeteTime: 2019-07-20 16:15
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	@Autowired
	private StudentServer studentServer;
	@Test
	public void test(){
		List<Student> students =this.studentServer
				.listStudent();
		System.out.println(students.get(0).getSname());
		List<Student> students1=this.studentServer.listStudent();
		System.out.println(students1.get(1).getSname());
	}
}
