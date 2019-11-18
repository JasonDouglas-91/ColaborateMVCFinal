package com.combinationMVC.boot.exploreComputer.web.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.combinationMVC.boot.exploreComputer.domain.UsersDomain;
import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.services.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<UsersDomain> getUserData(){
        List<UsersDomain> usersDomainList =this.userService.getAllUsers();
        return usersDomainList;
    }
    
	/*
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) public
	 * ResponseEntity<String> deleteUser(@PathVariable Long id) {
	 * this.userService.deleteUser(id); return new
	 * ResponseEntity<String>("User has been deleted", HttpStatus.OK); }
	 */
    
    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
    public String findUser(@PathVariable Long userId, Model model) {
    	User user = this.userService.findUser(userId); 
    	model.addAttribute("user", user);
    	return "home";
    }
    
    @GetMapping("/test")
    public String test() {
    	return "index2";
    }
    
}
