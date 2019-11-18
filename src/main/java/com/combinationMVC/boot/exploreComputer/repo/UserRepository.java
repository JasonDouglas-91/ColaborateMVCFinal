package com.combinationMVC.boot.exploreComputer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.combinationMVC.boot.exploreComputer.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findUserById(long id);
}
