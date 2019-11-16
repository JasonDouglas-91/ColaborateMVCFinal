package com.combinationMVC.boot.exploreComputer.services;

import com.combinationMVC.boot.exploreComputer.domain.UsersDomain;
import com.combinationMVC.boot.exploreComputer.entity.User;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
