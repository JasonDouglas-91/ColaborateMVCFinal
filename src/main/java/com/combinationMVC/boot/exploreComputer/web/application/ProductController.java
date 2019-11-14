package com.combinationMVC.boot.exploreComputer.web.application;

import com.combinationMVC.boot.exploreComputer.domain.ProductsDomain;
import com.combinationMVC.boot.exploreComputer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<ProductsDomain> getProductData(){
        List<ProductsDomain> productsDomainList = this.productService.getAllProducts();

        return productsDomainList;
    }
}
