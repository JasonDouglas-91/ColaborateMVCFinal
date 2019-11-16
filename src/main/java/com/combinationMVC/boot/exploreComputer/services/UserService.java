package com.combinationMVC.boot.exploreComputer.services;

import com.combinationMVC.boot.exploreComputer.domain.User;
import com.combinationMVC.boot.exploreComputer.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(Long id,String firstName, String lastName, String phoneNumber, String Email, LocalDate startDate, String cardInfo){
      if(!userRepository.existsById(id)){
          userRepository.save(new User(id,firstName,lastName,phoneNumber,Email,startDate,cardInfo));
      }
      return null;
    }

    public Iterable<User> lookup(){
        return userRepository.findAll();
    }
    public long total(){
        return userRepository.count();
    }
}
