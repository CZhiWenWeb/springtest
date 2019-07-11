package com.example.service;

import com.example.bean.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentServer {
	Student select(String sno);

	void addStudents(List<Student> students);
}