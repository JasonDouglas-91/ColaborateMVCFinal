package com.combinationMVC.boot.exploreComputer.services;

import com.combinationMVC.boot.exploreComputer.domain.ProductsDomain;
import com.combinationMVC.boot.exploreComputer.entity.Product;
import com.combinationMVC.boot.exploreComputer.repo.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private static final Logger logger  = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<ProductsDomain> getAllProducts(){
        Iterable<Product> products = this.productRepository.findAll();
//        System.out.println(products.toString()+"============I'm in!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Map<Long,ProductsDomain> productsDomainMap = new HashMap<>();
        products.forEach(product -> {
//            System.out.println(product+"============This is product!!!");
            ProductsDomain productsDomain = new ProductsDomain();
            productsDomain.setProductId(product.getId());
            productsDomain.setProductName(product.getName());
            productsDomain.setProductType(product.getType());
            productsDomain.setProductPrice(product.getPrice());
            productsDomain.setProductDetail(product.getDescription());
            productsDomainMap.put(product.getId(),productsDomain);

        });

        List<ProductsDomain> productsDomains = new ArrayList<>();
        for(Long productId:productsDomainMap.keySet()){
            productsDomains.add(productsDomainMap.get(productId));
        }

        return productsDomains;
    }
    
    public List<Product> getAllProduct(){
        Iterable<Product> products = this.productRepository.findAll();
//        System.out.println(products.toString()+"============I'm in!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Map<Long,Product> productsDomainMap = new HashMap<>();
        products.forEach(product -> {
//            System.out.println(product+"============This is product!!!");
            Product productsDomain = new Product();
            productsDomain.setId(product.getId());
            productsDomain.setName(product.getName());
            productsDomain.setType(product.getType());
            productsDomain.setPrice(product.getPrice());
            productsDomain.setDescription(product.getDescription());
            productsDomainMap.put(product.getId(),productsDomain);

        });

        List<Product> productsDomains = new ArrayList<>();
        for(Long productId:productsDomainMap.keySet()){
            productsDomains.add(productsDomainMap.get(productId));
        }

        return productsDomains;
    }

}
