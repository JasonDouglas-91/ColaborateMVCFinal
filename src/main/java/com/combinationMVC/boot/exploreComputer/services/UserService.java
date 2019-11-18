package com.combinationMVC.boot.exploreComputer.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.combinationMVC.boot.exploreComputer.domain.UsersDomain;
import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void deleteUser(long id) {
    	this.userRepository.deleteById(id);
    }
    
    public User findUser(long id) {
    	
    	User user = this.userRepository.findUserById(id);
    	User foundUser = new User();
    	foundUser.setId(user.getId());
    	foundUser.setUserId(user.getUserId());
    	foundUser.setUserPassword(user.getUserPassword());
    	foundUser.setFirstName(user.getFirstName());
    	foundUser.setAddress(user.getAddress());
    	foundUser.setEmail(user.getEmail());
    	foundUser.setPhoneNumber(user.getPhoneNumber());
    	foundUser.setCardInfo(user.getCardInfo());
    	foundUser.setLastName(user.getLastName());
    	return foundUser;
    }
    public List<UsersDomain> getAllUsers(){

        Iterable<User> users = this.userRepository.findAll();
        Map<Long,UsersDomain> usersDomainMap = new HashMap<>();
        users.forEach(user -> {
            UsersDomain usersDomain = new UsersDomain();
            usersDomain.setUserId(user.getId());
            usersDomain.setUserNickName(user.getUserId());
            usersDomain.setUserPassword(user.getUserPassword());
            usersDomain.setUserFirstName(user.getFirstName());
            usersDomain.setUserLastName(user.getLastName());
            usersDomain.setUserEmail(user.getEmail());
            usersDomain.setUserAddress(user.getAddress());
            usersDomain.setDate(user.getStartDate());
            usersDomain.setCardInfo(user.getCardInfo());
            usersDomainMap.put(user.getId(),usersDomain);
        });
        List<UsersDomain> usersDomains = new ArrayList<>();
        for(Long userId:usersDomainMap.keySet()){
            usersDomains.add(usersDomainMap.get(userId));
        }

        return usersDomains;
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
