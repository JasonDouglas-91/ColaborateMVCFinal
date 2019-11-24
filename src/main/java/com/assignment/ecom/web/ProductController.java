package com.assignment.ecom.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assignment.ecom.model.Product;
import com.assignment.ecom.repository.ProductRepository;
import com.assignment.ecom.service.ProductService;
import com.assignment.ecom.validator.ProductValidator;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductValidator productValidator;

	/*
	 * @GetMapping("/testProduct") public String test() { return
	 * "This is test for Product"; }
	 * 
	 * @GetMapping("/products") public List<Product> all() { return
	 * productRepository.findAll(); }
	 * 
	 * @PostMapping("/products") public Product newProduct(@RequestBody Product
	 * product) { return productRepository.save(product); }
	 * 
	 * @GetMapping("/products/{id}") public Product getOneProduct(@PathVariable Long
	 * id) { return productRepository.findById(id) .orElseThrow(() -> new
	 * ProductNotFoundException(id)); }
	 * 
	 * @PutMapping("/products/{id}") public Product replaceProduct(@RequestBody
	 * Product newProduct, @PathVariable Long id) { return
	 * productRepository.findById(id) .map(product -> {
	 * product.setName(newProduct.getName()); product.setType(newProduct.getType());
	 * product.setPrice(newProduct.getPrice());
	 * product.setDescription(newProduct.getDescription()); return
	 * productRepository.save(newProduct); }) .orElseGet(() -> {
	 * newProduct.setId(id); return productRepository.save(newProduct); }); }
	 * 
	 * @DeleteMapping("products/{id}") public void deleteProduct(@PathVariable Long
	 * id) { productRepository.deleteById(id); }
	 */

    @GetMapping({"/", "/product-list"})
    public ModelAndView listProduct() {
        List<Product> list = productRepository.findAll();

        ModelAndView model = new ModelAndView("product-list");
        model.addObject("lists", list);

        return model;
    }

    @GetMapping("/search-product")
    public ModelAndView searchProduct(@RequestParam(value="searchData") String searchData) {
        List<Product> list = productRepository.findProductsByDescriptionContainsOrNameContains(searchData, searchData);

        ModelAndView model = new ModelAndView("product-list");
        model.addObject("lists", list);

        return model;
    }

    @GetMapping("/detail-product")
    public ModelAndView detailProduct(@RequestParam(value="productId") Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        ModelAndView model = new ModelAndView("product-detail");
        model.addObject("product", product.get());

        return model;
    }
    
    @GetMapping("/add-product")
    public String addProduct(Model model) {
    	model.addAttribute("productForm", new Product());
    	
    	return "add-product";
    }
    
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("productForm") Product product, BindingResult bindingResult) {
    	
    	productValidator.validate(product, bindingResult);
    	
    	if(bindingResult.hasErrors()) {
    		return "add-product";
    	}
    	
    	productService.save(product);
    	
    	return "redirect:/product-list";
    }
}
