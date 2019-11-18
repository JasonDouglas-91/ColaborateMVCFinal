package com.combinationMVC.boot.exploreComputer.web.application;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.combinationMVC.boot.exploreComputer.entity.Product;
import com.combinationMVC.boot.exploreComputer.services.ProductService;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/products", method= RequestMethod.GET)
    public String getProductData(Model model){
        List<Product> productsDomainList = this.productService.getAllProduct();
        model.addAttribute("products", productsDomainList);
        return "product";
    }
    
}
