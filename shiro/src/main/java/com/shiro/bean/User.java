package com.shiro.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
public class User {
    /**
     * user主键
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * user名字
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * user密码
     */
    @Column(name = "pass_word")
    private String passWord;

    /**
     * user新建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否有效 1：有效 0：锁定
     */
    private String staus;

    /**
     * 获取user主键
     *
     * @return id - user主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置user主键
     *
     * @param id user主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取user名字
     *
     * @return user_name - user名字
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置user名字
     *
     * @param userName user名字
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取user密码
     *
     * @return pass_word - user密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置user密码
     *
     * @param passWord user密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取user新建时间
     *
     * @return create_time - user新建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置user新建时间
     *
     * @param createTime user新建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否有效 1：有效 0：锁定
     *
     * @return staus - 是否有效 1：有效 0：锁定
     */
    public String getStaus() {
        return staus;
    }

    /**
     * 设置是否有效 1：有效 0：锁定
     *
     * @param staus 是否有效 1：有效 0：锁定
     */
    public void setStaus(String staus) {
        this.staus = staus;
    }
}