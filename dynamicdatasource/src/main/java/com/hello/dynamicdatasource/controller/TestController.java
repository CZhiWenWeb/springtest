package com.hello.dynamicdatasource.controller;

import com.hello.dynamicdatasource.beans.Product;
import com.hello.dynamicdatasource.common.CommonResponse;
import com.hello.dynamicdatasource.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author: czw
 * @CreateTime: 2019-08-02 17:16
 * @UpdeteTime: 2019-08-02 17:16
 * @Description:
 */
@RestController
@RequestMapping("/product")
public class TestController {
	@Autowired
	private ProductService productService;
	@GetMapping("/{id}")
	public CommonResponse select(@PathVariable("id") String id){
		return productService.getProductList(id);
	}

	@PostMapping
	public CommonResponse addProduct(@Validated Product product){
		//Product product=new Product();
		//product.setProductName("test");
		//product.setProductPrice(10.0);
		return productService.insertProduct(product);
	}

	@GetMapping
	public CommonResponse selectAll(){
		return productService.getAllProducts();
	}

}
