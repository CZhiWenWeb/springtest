package com.example.mapper;

import com.example.bean.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
	//@Select("select * from t_student where sno=#{sno}")
	//@Results(id = "student",value = {
	//	@Result(property = "sno",column = "sno",javaType = String.class),
	//	@Result(property = "sname",column = "sname",javaType = String.class),
	//	@Result(property = "ssex",column = "ssex",javaType = String.class)
	//})
	@SelectProvider(type = StudentsBuilder.class,method = "buildStudentBySno")
	Student select(@Param("sno") String sno);

	@InsertProvider(type = StudentsBuilder.class,method = "addStudents")
	void addStudents(@Param("students") List<Student> students);
}