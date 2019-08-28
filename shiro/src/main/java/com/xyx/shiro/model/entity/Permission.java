package com.xyx.shiro.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 当实体类与其映射的数据库表名不同名时需要使用 @Table注解说明
 * @Colum同上，主键Id会用到@Id注解
 */
@Table(name = "permission")
public class Permission implements Serializable {
    private static final long serialVersionUID = 5220723950096610423L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 资源名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 权限代码字符串
     */
    @Column(name = "per_code")
    private String perCode;

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
     * 获取资源名称
     *
     * @return name - 资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名称
     *
     * @param name 资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取权限代码字符串
     *
     * @return per_code - 权限代码字符串
     */
    public String getPerCode() {
        return perCode;
    }

    /**
     * 设置权限代码字符串
     *
     * @param perCode 权限代码字符串
     */
    public void setPerCode(String perCode) {
        this.perCode = perCode == null ? null : perCode.trim();
    }
}