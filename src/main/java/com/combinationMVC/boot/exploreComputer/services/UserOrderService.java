package com.combinationMVC.boot.exploreComputer.services;

import com.combinationMVC.boot.exploreComputer.repo.ProductRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserOrderRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserOrderService {
    private ProductRepository productRepository;
    private UserOrderRepository userOrderRepository;
    private UserRepository userRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Logger log  = LoggerFactory.getLogger(UserOrderService.class);

    @Autowired
    public UserOrderService(ProductRepository productRepository, UserOrderRepository userOrderRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userOrderRepository = userOrderRepository;
        this.userRepository = userRepository;
    }

//    public List<Order> getOrderbyDate(Date date){
    public String getOrderbyDate(Date date){
//        Iterable<Product> products = this.productRepository.findAll();
//        Map<Long,Order> orderMap = new HashMap<>();
//        products.forEach(product -> {
//            Order order = new Order();
//            order.setProductId(product.getId());
//            order.setProductName(product.getName());
//            order.setProductPrice(product.getPrice());
//            orderMap.put(product.getId(),order);
//        });
//
        java.sql.Date convertedDate = new java.sql.Date(date.getTime());
        System.out.println("THis is date>>>>>>>>>>>>>>>>"+convertedDate);
//        Iterable<UserOrder> userOrders = this.userOrderRepository.findByDate(new java.sql.Date(date.getTime()));
//        if(null!=userOrders){
//            userOrders.forEach(userOrder -> {
//                Optional<User> userResponse = this.userRepository.findById(userOrder.getUserId());
//                if(userResponse.isPresent()){
//                    User user = userResponse.get();
//                    Order order = orderMap.get(userOrder.getId());
//                    order.setDate(date);
//                    order.setFirstName(user.getFirstName());
//                    order.setLastName(user.getLastName());
//                    order.setUserId(user.getId());
//                }
//            });
//        }
//        List<Order> orders = new ArrayList<>();
//        for(Long productId:orderMap.keySet()){
//            orders.add(orderMap.get(productId));
//        }
//        return orders;
        return "test";
    }
//    public List<UserOrder> getOrder(){
//        List<UserOrder> order = userOrderRepository.findAll();
////        Iterable<Product> products = this.productRepository.findAll();
////        log.info("this is info");
////        log.debug("-------------------------------------------------------------------test");
//        return order;
//
//    }

//
//    public List<Order> getOrderForDate(String dateString){
//        Date date = this.createDateFromDateString(dateString);
//        Iterable<Product> products = this.productRepository.findAll();
//        Map<Long,Order> orderMap = new HashMap<>();
//            products.forEach(product -> {
//                Order order = new Order();
//                order.setProductId(product.getId());
//                order.setProductName(product.getName());
//                orderMap.put(product.getId(),order);
//            });
//
//        Iterable<UserOrder> userOrders = this.userOrderRepository.findByDate(new java.sql.Date(date.getTime()));
//        log.debug("-------------------------------------------------------------------test");
////        Iterable<UserOrder> userOrders = this.userOrderRepository.findAll();
//
////        log.debug("-------------------------------------------------------------------test: {}",userOrders);
//        if(null!=userOrders){
//            userOrders.forEach(userOrder -> {
//                Optional<User> user = this.userRepository.findById(userOrder.getUserId());
//                if(null!=user){
//                    Order order =orderMap.get(userOrder.getId());
//                    order.setDate(date);
//
//                }
//            });
//        }
//        List<Order> orders = new ArrayList<>();
//        for(Long productId:orderMap.keySet()){
//            orders.add(orderMap.get(productId));
//        }
//        return orders;
//    }
////
//    private Date createDateFromDateString(String dateString){
//        Date date = null;
//        if(null!=dateString){
//            try{
//                date = DATE_FORMAT.parse(dateString);
//            }catch(ParseException pe) {
//                date = new Date();
//            }
//        }
//        else{
//            date = new Date();
//        }
//        return date;
//    }
}
