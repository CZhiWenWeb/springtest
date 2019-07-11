package com.springbootjson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @Author: czw
 * @CreateTime: 2019-07-10 10:48
 * @UpdeteTime: 2019-07-10 10:48
 * @Description:
 */
@Data
public class User implements Serializable {
	private static final long serialVersionUID = -3960586092069561703L;
	public interface UserNameView{}
	public interface AllUserFieldView extends UserNameView{}

	@JsonProperty("n")
	@JsonView(UserNameView.class)
	private String name;

	@JsonView(AllUserFieldView.class)
	private int age;

	@JsonView(AllUserFieldView.class)
	private String password;

	@JsonView(AllUserFieldView.class)
	/**
	 * 属性重命名
	 */
	@JsonProperty("bir")
	/**
	 * 格式化
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthday;

}
