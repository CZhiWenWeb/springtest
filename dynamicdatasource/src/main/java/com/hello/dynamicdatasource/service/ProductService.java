package com.hello.dynamicdatasource.service;

import com.hello.dynamicdatasource.beans.Product;
import com.hello.dynamicdatasource.common.CommonResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService{
	/**
	 * 获取所有产品信息
	 * @return
	 */
	CommonResponse getAllProducts();

	/**
	 * 根据id查询
	 * @param ids
	 * @return
	 */
	CommonResponse getProductList(String ids);

	/**
	 * 增加产品
	 * @param product
	 * @return
	 */
	CommonResponse insertProduct(Product product);
}
