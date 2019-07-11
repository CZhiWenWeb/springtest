package com.example.controller;

import com.example.bean.BlogProperties;
import com.example.bean.ConfigBean;
import com.example.bean.Student;
import com.example.service.impl.StudentServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-01 17:18
 * @UpdeteTime: 2019-07-01 17:18
 * @Description:
 */
@RestController
public class Example {
	@Autowired
	private BlogProperties blogProperties;
	@Autowired
	private ConfigBean configBean;
	@Autowired
	StudentServerImpl studentMapper;
	@RequestMapping("/")
	String home(){
		List<Student> students=new ArrayList<>();
		for (int i=0;i<2;i++){
			Student student=new Student();
			student.setSname(i+"");
			student.setSno(i+"");
			student.setSsex(i+"");
			students.add(student);
		}
		studentMapper.addStudents(students);
		return studentMapper.select("001").getSname();
	}

}
