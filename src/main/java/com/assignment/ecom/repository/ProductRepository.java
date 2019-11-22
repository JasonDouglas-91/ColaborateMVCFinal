package com.assignment.ecom.repository;

import com.assignment.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByDescriptionContainsOrNameContains(String description, String name);
    
}
