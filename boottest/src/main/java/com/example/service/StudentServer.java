package com.example.service;

import com.example.bean.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
@CacheConfig(cacheNames = "student")
@Repository
public interface StudentServer {
	@Cacheable(key = "#p0.sno")
	Student select(String sno);
	@CachePut(key = "#p0.sno")
	void addStudents(List<Student> students);
	@CacheEvict(cacheNames = "student",allEntries = true)
	void deleteStudents(List<String> sons);
	@Cacheable(cacheNames = "students")
	List<Student> listStudent();
}