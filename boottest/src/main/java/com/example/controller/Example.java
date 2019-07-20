package com.example.controller;

import com.example.bean.BlogProperties;
import com.example.bean.ConfigBean;
import com.example.bean.Student;
import com.example.service.impl.StudentServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
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
	StudentServerImpl studentServerImpl;
	@RequestMapping("/")
	String home(){
		List<Student> students=new ArrayList<>();
		for (int i=0;i<2;i++){
			Integer integer=i+3;
			Student student=new Student();
			student.setSname(i+"");
			student.setSno(integer);
			student.setSsex(i+"");
			student.setTime(LocalDate.now());
			students.add(student);
		}
		studentServerImpl.addStudents(students);
		return "";
	}
	@RequestMapping("/deleteStudents")
	String delete(){
		List<String> snos=new ArrayList<>();
		snos.add("0");snos.add("1");
		studentServerImpl.deleteStudents(snos);
		return "";
	}
	@RequestMapping("/selectStudents")
	String select(){
		List<Student> students=studentServerImpl.listStudent();
		String string="";
		for (int i=0;i<students.size();i++){
			System.out.println(students.get(i).getSname());
		}
		return "";
	}
}
