package com.assignment.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.ecom.model.Product;
import com.assignment.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;
	
	@Override
	public void save(Product product) {
		product.setName(product.getName());
		product.setPrice(product.getPrice());
		product.setType(product.getType());
		product.setDescription(product.getDescription());
		product.setImage(product.getImage());
		
		productrepository.save(product);
	}
	
	@Override
	public Product findByName(String name) {
		return productrepository.findByName(name);
	}

}
