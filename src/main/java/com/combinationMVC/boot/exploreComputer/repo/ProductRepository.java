package com.combinationMVC.boot.exploreComputer.repo;

import com.combinationMVC.boot.exploreComputer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    Product findbyid(Long productId);
}
