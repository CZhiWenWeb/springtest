package com.controller;

import com.mysql1dao.MysqlStudentMapper1;
import com.mysql2dao.MysqlStudentMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.StudentService;

import java.util.List;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-07-08 14:26
 * @UpdeteTime: 2019-07-08 14:26
 * @Description:
 */
@RestController
public class StudentController {
	@Autowired
	private MysqlStudentMapper1 studentMapper1;

	@Autowired
	private MysqlStudentMapper2 studentMapper2;
	@RequestMapping("students1")
	public List<Map<String,Object>> students1(){
		return studentMapper1.getStudents();
	}

	@RequestMapping("students2")
	public List<Map<String,Object>> students2(){
		return studentMapper2.getStudents();
	}
}
