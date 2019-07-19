package com.example.service;

import com.example.bean.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Repository;

import java.util.List;
@CacheConfig(cacheNames = "student")
@Repository
public interface StudentServer {

	Student select(String sno);

	void addStudents(List<Student> students);

	List<Student> selects(List<String> strings);
}