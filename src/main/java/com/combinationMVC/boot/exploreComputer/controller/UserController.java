package com.combinationMVC.boot.exploreComputer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.exceptions.UserNotFoundException;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/test")
	public String home(){
		return "home";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index2";
	}
	
	@GetMapping("/users")
	public List<User> all(){
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User newUser(@RequestBody User user){
		return userRepository.save(user);
	}

	@GetMapping("/users/{id}")
	public User getOneUser(@PathVariable Long id){
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
	}
	@PutMapping("/users/{id}")
	public User replaceUser(@RequestBody User newUser, @PathVariable Long id){
		return userRepository.findById(id)
				.map(user->{
					user.setFirstName(newUser.getFirstName());
					user.setLastName(newUser.getLastName());
					user.setPhoneNumber(newUser.getPhoneNumber());
					user.setEmail(newUser.getEmail());
					user.setStartDate(newUser.getStartDate());
					user.setCardInfo(newUser.getCardInfo());
					return userRepository.save(newUser);
				})
				.orElseGet(()->{
					newUser.setId(id);
					return userRepository.save(newUser);
				});
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id){
		userRepository.deleteById(id);
	}

//	@RequmestMapping("/")
////	public String hoe() {
//		return "home.jsp";
//	}
//
//	@RequestMapping(value = "/user",method=RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public User createUser(@RequestBody @Validated User user){
//		return userRepository.save(user);
//	}
//
//	private User verifyUser(int userId) throws NoSuchElementException{
////		User user = UserRepository.
//		return null;
//	}
}
