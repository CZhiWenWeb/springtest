package com.xyx.shiro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xyx.shiro.model.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.time.LocalDateTime;

/**
 * @Author: czw
 * @CreateTime: 2019-08-26 16:31
 * @UpdeteTime: 2019-08-26 16:31
 * @Description:
 */
@Table(name = "user")
public class UserDto extends User {
	/**
	 * 登入时间
	 */
	@Transient
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@Getter
	@Setter
	private LocalDateTime loginTime;
}
