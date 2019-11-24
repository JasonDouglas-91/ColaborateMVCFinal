package com.assignment.ecom.service;

import com.assignment.ecom.model.Product;

public interface ProductService {
	void save(Product product);
	
	Product findByName(String name);
}
