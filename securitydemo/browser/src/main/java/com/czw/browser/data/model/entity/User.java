package com.czw.browser.data.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "t_user")
public class User implements Serializable {
	private static final long serialVersionUID = -6356538603348177065L;
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * 帐号
	 */
	@Column(name = "account")
	private String account;

	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 昵称
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 注册时间
	 */
	@Column(name = "reg_time")
	private Date regTime;

	@Getter
	@Setter
	@Column(name = "phone")
	private String phone;

	/**
	 * 获取ID
	 *
	 * @return id - ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置ID
	 *
	 * @param id ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取帐号
	 *
	 * @return account - 帐号
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置帐号
	 *
	 * @param account 帐号
	 */
	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	/**
	 * 获取密码
	 *
	 * @return password - 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 *
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 获取昵称
	 *
	 * @return username - 昵称
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置昵称
	 *
	 * @param username 昵称
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * 获取注册时间
	 *
	 * @return reg_time - 注册时间
	 */
	public Date getRegTime() {
		return regTime;
	}

	/**
	 * 设置注册时间
	 *
	 * @param regTime 注册时间
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}