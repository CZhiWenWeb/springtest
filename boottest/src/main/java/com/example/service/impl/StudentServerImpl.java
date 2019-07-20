package com.example.service.impl;

import com.example.bean.Student;
import com.example.service.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-05 17:27
 * @UpdeteTime: 2019-07-05 17:27
 * @Description:
 */
@Service
public class StudentServerImpl implements StudentServer {
	@Autowired
	com.example.mapper.StudentMapper studentMapper;

	@Override
	public Student select(String sno) {
		return studentMapper.select("001");
	}

	@Override
	public void addStudents(List<Student> students) {
		studentMapper.addStudents(students);
	}

	@Override
	public void deleteStudents(List<String> sons) {
		studentMapper.deleteStudents(sons);
	}

	@Override
	public List<Student> listStudent() {
		return studentMapper.listStudents();
	}

	//@Override
	//public List<Student> selects(List<String> strings) {
	//	return studentMapper.selectStudents(strings);
	//}
}
