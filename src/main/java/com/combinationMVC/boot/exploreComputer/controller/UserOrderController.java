package com.combinationMVC.boot.exploreComputer.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.entity.UserOrder;
import com.combinationMVC.boot.exploreComputer.repo.UserOrderRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;

@Controller
public class UserOrderController {
    @Autowired
    private UserOrderRepository userOrderRepository;
    private UserRepository userRepository;

    @GetMapping("/userOrders")
    public List<UserOrder> all(){
        return userOrderRepository.findAll();
    }
    
    @GetMapping("/test2")
    public String testing(Model model) {
    	model.addAttribute("userOrder", userOrderRepository.findAll());
    	return "home";
    }
    
    @GetMapping("/userOrdersDate")
    public String listByDate(@RequestParam(value = "date",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, Model model) {
    	
    	model.addAttribute("userOrder", userOrderRepository.findAll());
    	return "home";
    }
    
    
    @PostMapping("/userOrders")
    public UserOrder newUserOrder(@RequestBody UserOrder userOrder, @PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if(user ==null){
            throw new RuntimeException("User doesn't exist "+id);
        }
        return userOrderRepository.save(new UserOrder());

    }
}
