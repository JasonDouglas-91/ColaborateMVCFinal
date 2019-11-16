package com.combinationMVC.boot.exploreComputer.controller;

import com.combinationMVC.boot.exploreComputer.domain.Product;
import com.combinationMVC.boot.exploreComputer.exceptions.ProductNotFoundException;
import com.combinationMVC.boot.exploreComputer.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/testProduct")
    public String test(){
        return "This is test for Product";
    }
    @GetMapping("/products")
    public List<Product> all(){
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException(id));
    }
    @PutMapping("/products/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setType(newProduct.getType());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    return productRepository.save(newProduct);
                })
                .orElseGet(()->{
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }
    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }

}
