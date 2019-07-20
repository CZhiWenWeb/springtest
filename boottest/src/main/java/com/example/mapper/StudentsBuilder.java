package com.example.mapper;

import com.example.bean.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Author: czw
 * @CreateTime: 2019-07-08 15:58
 * @UpdeteTime: 2019-07-08 15:58
 * @Description:
 */
public class StudentsBuilder {
	/**全表查询*/
	public static String listStudents(){
		return new SQL(){{
			SELECT("*");
			FROM("t_student");
		}}.toString();
	}
	/**批量删除*/
	public static String deleteStudent(final List<String> snos){
		return new SQL(){{
			DELETE_FROM("t_student");
			if (!snos.isEmpty()){
				String fields="(";
				for (int i=0;i<snos.size();i++){
					if (i==snos.size()-1){
						fields+=snos.get(i)+")";
					}else {
						fields+=snos.get(i)+",";
					}
				}
				WHERE("sno in"+fields);
			}
		}}.toString();
	}
	public static String buildStudentBySno(final String sno) {
		return new SQL() {{
			SELECT("*");
			FROM("t_student");
			if (sno != null) {
				WHERE("sno=#{sno}||'%'");
			}
		}}.toString();
	}

	/**
	 * 批量添加
	 * @param students
	 * @return
	 */
	public static String addStudents(final List<Student> students) {
		return new SQL() {
			{
				INSERT_INTO("t_student");
				INTO_COLUMNS("sname");
				INTO_COLUMNS("sno");
				INTO_COLUMNS("ssex");

				for (int i = 0; i < students.size(); i++) {
					if (i!=0){
						INTO_VALUES("("+students.get(i).getSname());
					}else {
						INTO_VALUES(students.get(i).getSname());
					}
					INTO_VALUES(students.get(i).getSno().toString());
					INTO_VALUES(students.get(i).getTime().toString());
					if (i!=students.size()-1){
						INTO_VALUES(students.get(i).getSsex()+")");
					}else {
						INTO_VALUES(students.get(i).getSsex());
					}
				}
			}
		}.toString();
	}

}


