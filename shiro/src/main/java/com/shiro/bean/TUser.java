package com.shiro.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class TUser {
    /**
     * 用户id
     */
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "pass_word")
    private String passWord;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否有效 1：有效 0：锁定
     */
    private String status;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return pass_word - 密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置密码
     *
     * @param passWord 密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否有效 1：有效 0：锁定
     *
     * @return status - 是否有效 1：有效 0：锁定
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否有效 1：有效 0：锁定
     *
     * @param status 是否有效 1：有效 0：锁定
     */
    public void setStatus(String status) {
        this.status = status;
    }
}