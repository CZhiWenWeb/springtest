package com.service.impl;

import com.mysql1dao.MysqlStudentMapper1;
import com.mysql2dao.MysqlStudentMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.StudentService;

import java.util.List;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-07-08 14:18
 * @UpdeteTime: 2019-07-08 14:18
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	MysqlStudentMapper1 studentMapper1;
	@Autowired
	MysqlStudentMapper2 studentMapper2;
	@Override
	public List<Map<String, Object>> getStudentsFrom1() {
		return studentMapper1.getStudents();
	}

	@Override
	public List<Map<String, Object>> getStudentsFrom2() {
		return studentMapper2.getStudents();
	}
}
