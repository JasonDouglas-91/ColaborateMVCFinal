package com.assignment.ecom.repository;

import com.assignment.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
