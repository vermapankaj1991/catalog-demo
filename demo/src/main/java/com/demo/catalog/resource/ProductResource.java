package com.demo.catalog.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.catalog.constants.Constants;
import com.demo.catalog.domain.Product;
import com.demo.catalog.service.ProductService;

@RestController
@RequestMapping(value=Constants.BASE_CONTEXT_PATH)
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@ResponseBody
	@GetMapping(value="/products")
	public List<Product> getAllProducts(@RequestParam(required = false) String productType, @RequestParam(required= false) Boolean isPromoApplicable){
		return service.getAllProducts(productType, isPromoApplicable);		
	}

}
