package com.demo.catalog.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.catalog.domain.Product;
@Repository
public class ProductRepository {
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		products.add(new Product(1,"ABC Mutual Funds", "Finance", 1000.0, true));
		products.add(new Product(2,"XYZ Co Shares", "Finance", 200.0, false));
		products.add(new Product(3,"PQR Shares", "Finance", 3000.0, true));
		products.add(new Product(4,"123 Mutual Funds", "Capital Market", 100.0, false));
		products.add(new Product(5,"345 Mutual Funds", "Capital Market", 200.0, false));
		
		return products;
	}

}
