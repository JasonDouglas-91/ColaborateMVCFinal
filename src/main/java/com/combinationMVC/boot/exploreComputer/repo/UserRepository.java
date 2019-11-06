package com.combinationMVC.boot.exploreComputer.repo;

import com.combinationMVC.boot.exploreComputer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
