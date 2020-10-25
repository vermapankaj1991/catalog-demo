package com.demo.catalog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.catalog.domain.Product;
import com.demo.catalog.repo.ProductRepository;
import com.demo.catalog.validator.RequestValidator;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private RequestValidator validator;
	/**
	 * Get all product list
	 * @param isPromoApplicatble 
	 * @param productType 
	 * @return List<Product>
	 */
	public List<Product> getAllProducts(String productType, Boolean isPromoApplicatble) {		
		List<Product> products = productRepo.getAllProducts();
		return filterProducts(productType, isPromoApplicatble, products);
			
	}
	/**
	 * 
	 * @param productType
	 * @param isPromoApplicatble
	 * @param products
	 * @return
	 */
	private List<Product> filterProducts(String productType, Boolean isPromoApplicatble, List<Product> products) {
		
		if(productType != null && isPromoApplicatble != null){
			validator.validateProductFilter(productType);
			return products.stream().filter(i->( (productType.equalsIgnoreCase(i.getProductType())) && (i.getIsPromoApplicable() == isPromoApplicatble))).collect(Collectors.toList());
		}else if(productType != null){
			validator.validateProductFilter(productType);
			return products.stream().filter(i-> productType.equalsIgnoreCase(i.getProductType())).collect(Collectors.toList());
		}else if(isPromoApplicatble != null){
			return products.stream().filter(i-> i.getIsPromoApplicable() == isPromoApplicatble).collect(Collectors.toList());
		}else{
			return products;
		}
	}
	
	

}
