package com.mysql2dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2019-07-08 11:38
 * @UpdeteTime: 2019-07-08 11:38
 * @Description:
 */
@Component
@Mapper
public interface MysqlStudentMapper2 {
	@SelectProvider(type = StudentBuilder.class,method = "buildGetStudents")
	List<Map<String,Object>> getStudents();
}

