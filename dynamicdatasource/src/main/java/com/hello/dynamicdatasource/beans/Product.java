package com.hello.dynamicdatasource.beans;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Table(name = "t_product")
public class Product {
    /**
     * 主键
     */
    @Id
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 名字
     */
    @NotBlank
    @Column(name = "product_name")
    private String productName;

    /**
     * 价格
     */
    @Positive
    @Column(name = "product_price")
    private Double productPrice;

    /**
     * 获取主键
     *
     * @return product_id - 主键
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置主键
     *
     * @param productId 主键
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取名字
     *
     * @return product_name - 名字
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置名字
     *
     * @param productName 名字
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取价格
     *
     * @return product_price - 价格
     */
    public Double getProductPrice() {
        return productPrice;
    }

    /**
     * 设置价格
     *
     * @param productPrice 价格
     */
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}