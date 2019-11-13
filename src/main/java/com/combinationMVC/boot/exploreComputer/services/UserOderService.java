package com.combinationMVC.boot.exploreComputer.services;

import com.combinationMVC.boot.exploreComputer.domain.Order;
import com.combinationMVC.boot.exploreComputer.entity.Product;
import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.entity.UserOrder;
import com.combinationMVC.boot.exploreComputer.repo.ProductRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserOrderRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class UserOderService {
    private ProductRepository productRepository;
    private UserOrderRepository userOrderRepository;
    private UserRepository userRepository;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Logger log  = LoggerFactory.getLogger(UserOderService.class);
    @Autowired
    public UserOderService(ProductRepository productRepository, UserOrderRepository userOrderRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userOrderRepository = userOrderRepository;
        this.userRepository = userRepository;
    }

    public List<Order> getOrderForDate(String dateString){
        Date date = this.createDateFromDateString(dateString);
        Iterable<Product> products = this.productRepository.findAll();
        Map<Long,Order> orderMap = new HashMap<>();
            products.forEach(product -> {
                Order order = new Order();
                order.setProductId(product.getId());
                order.setProductName(product.getName());
                orderMap.put(product.getId(),order);
            });

//        Iterable<UserOrder> userOrders = this.userOrderRepository.findByDate(new java.sql.Date(date.getTime()));
        log.debug("-------------------------------------------------------------------test");
        Iterable<UserOrder> userOrders = this.userOrderRepository.findAll();

//        log.debug("-------------------------------------------------------------------test: {}",userOrders);
//        if(null!=userOrders){
//            userOrders.forEach(userOrder -> {
//                Optional<User> user = this.userRepository.findById(userOrder.getUserId());
//                if(null!=user){
//                    Order order =orderMap.get(userOrder.getId());
//                    order.setDate(date);
////                    order.setFirstName(user);
//                }
//            });
//        }
        return null;
    }

    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe) {
                date = new Date();
            }
        }
        else{
            date = new Date();
        }
        return date;
    }
}
