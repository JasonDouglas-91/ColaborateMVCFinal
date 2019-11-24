package com.assignment.ecom.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.assignment.ecom.model.Product;
import com.assignment.ecom.service.ProductService;

@Component
public class ProductValidator implements Validator {

	@Autowired
	private ProductService productService;
	
	@Override
	public boolean supports(Class<?> clazz) {

		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		if (product.getName().length() < 4) {
			errors.rejectValue("name", "Size.productForm.name");
		}
		if(productService.findByName(product.getName()) != null) {
			errors.rejectValue("name", "Duplicate.productForm.name");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "NotEmpty");
		if (product.getType().length() < 4) {
			errors.rejectValue("type", "Size.productForm.type");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
		if (product.getPrice() <= 0 ) {
			errors.rejectValue("price", "Number.productForm.price");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		if (product.getDescription().length() < 4) {
			errors.rejectValue("description", "Size.productForm.description");
		}
		
	}
	

}
