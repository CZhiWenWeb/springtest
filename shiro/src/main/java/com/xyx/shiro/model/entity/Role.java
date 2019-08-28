package com.xyx.shiro.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = -7568287333398763256L;
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}