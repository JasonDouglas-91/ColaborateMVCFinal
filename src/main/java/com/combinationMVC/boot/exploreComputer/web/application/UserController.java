package com.combinationMVC.boot.exploreComputer.web.application;

import com.combinationMVC.boot.exploreComputer.domain.UsersDomain;
import com.combinationMVC.boot.exploreComputer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UsersDomain> getUserData(){
        List<UsersDomain> usersDomainList =this.userService.getAllUsers();
        return usersDomainList;
    }
}
