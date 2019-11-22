package com.assignment.ecom.service;

import com.assignment.ecom.Entity.OrderSet;
import com.assignment.ecom.model.Order;
import com.assignment.ecom.model.Product;
import com.assignment.ecom.model.User;

public interface OrderService {
	void createOrder(String userName,Long productId);
	
	
}
