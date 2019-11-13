package com.combinationMVC.boot.exploreComputer.controller;

import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.entity.UserOrder;
import com.combinationMVC.boot.exploreComputer.repo.UserOrderRepository;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserOrderController {
    @Autowired
    private UserOrderRepository userOrderRepository;
    private UserRepository userRepository;

    @GetMapping("/userOders")
    public List<UserOrder> all(){
        return userOrderRepository.findAll();
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
