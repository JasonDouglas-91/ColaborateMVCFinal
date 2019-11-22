package com.assignment.ecom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.ecom.Entity.OrderSet;
import com.assignment.ecom.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@GetMapping("/testOrder")
	public String test() {
		return "this is test for order";
	}
//	@PostMapping("/Order")
//	public String postOrder(@ModelAttribute("orderAdd")OrderSet orderAdd) {
//		orderService.createOrder();
//		
//		return "order";
//	}
}
