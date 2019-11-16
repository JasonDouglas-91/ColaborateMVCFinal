package com.combinationMVC.boot.exploreComputer.repo;

import com.combinationMVC.boot.exploreComputer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
