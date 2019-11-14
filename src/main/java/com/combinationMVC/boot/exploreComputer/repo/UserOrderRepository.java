package com.combinationMVC.boot.exploreComputer.repo;

import com.combinationMVC.boot.exploreComputer.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder,Long> {

//    List<UserOrder> findByDate(Date date);

}
