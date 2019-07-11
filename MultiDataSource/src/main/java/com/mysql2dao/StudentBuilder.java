package com.mysql2dao;

import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: czw
 * @CreateTime: 2019-07-09 08:35
 * @UpdeteTime: 2019-07-09 08:35
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