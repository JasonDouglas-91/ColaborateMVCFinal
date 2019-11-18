package com.assignment.ecom.web;

import com.assignment.ecom.exceptions.ProductNotFoundException;
import com.assignment.ecom.model.Product;
import com.assignment.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/testProduct")
    public String test() {
        return "This is test for Product";
    }

    @GetMapping("/products")
    public List<Product> all() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setType(newProduct.getType());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    return productRepository.save(newProduct);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping({"/", "/welcome"})
    public ModelAndView welcome() {
        List<Product> list = productRepository.findAll();

        //return back to index.jsp
        ModelAndView model = new ModelAndView("welcome");
        model.addObject("lists", list);

        return model;
    }

    private List<String> getList() {

        List<String> list = new ArrayList<String>();
        list.add("List A");
        list.add("List B");
        list.add("List C");
        list.add("List D");
        list.add("List E");
        list.add("List F");
        list.add("List G");
        list.add("List H");
        list.add("List J");
        list.add("List K");
        list.add("List L");
        list.add("List M");

        return list;
    }
}
