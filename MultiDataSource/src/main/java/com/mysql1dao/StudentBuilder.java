package com.mysql1dao;

import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: czw
 * @CreateTime: 2019-07-09 08:36
 * @UpdeteTime: 2019-07-09 08:36
 * @Description:
 */
public class StudentBuilder{
	public static String buildGetStudents(){
		return new SQL(){{
			SELECT("*");
			FROM("t_student");
		}}.toString();
	}
}