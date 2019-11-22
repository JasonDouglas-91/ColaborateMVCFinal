package com.assignment.ecom.service;

import java.sql.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.ecom.Entity.OrderSet;
import com.assignment.ecom.model.Order;
import com.assignment.ecom.model.Product;
import com.assignment.ecom.model.User;
import com.assignment.ecom.repository.OrderRepository;
import com.assignment.ecom.repository.ProductRepository;
import com.assignment.ecom.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Override
	public void createOrder(String userName,Long productId) {
		
		Order order = new Order();
//		Date date =  new Date()
		order.setProduct(productRepository.getOne(productId));
		order.setUser(userRepository.findByUsername(userName));
//		order.setDate(date);
		
		orderRepository.save(order);
	}
	
	
	
	
	
	
}
