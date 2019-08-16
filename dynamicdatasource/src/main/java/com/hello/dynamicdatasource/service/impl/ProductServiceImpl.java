package com.hello.dynamicdatasource.service.impl;

import com.hello.dynamicdatasource.beans.Product;
import com.hello.dynamicdatasource.common.CommonResponse;
import com.hello.dynamicdatasource.common.ResponseCode;
import com.hello.dynamicdatasource.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author: czw
 * @CreateTime: 2019-08-02 17:20
 * @UpdeteTime: 2019-08-02 17:20
 * @Description:
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

	@Override
	public CommonResponse getAllProducts() {
		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(findAll());
		response.setMessage("ProductServiceImpl"+"--"+"getAllProducts()");
		return response;
	}

	@Override
	public CommonResponse getProductList(String ids) {
		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(findByIds(ids));
		response.setMessage("ProductServiceImpl"+"--"+"getProductList()");
		return response;
	}

	@Override
	public CommonResponse insertProduct(Product product) {
		CommonResponse response=new CommonResponse();
		response.setCode(ResponseCode.SUCCESS);
		response.setData(save(product));
		response.setMessage("ProductServiceImpl"+"--"+"getProductList()");
		System.out.println(response.toString());
		return response;
	}
}
