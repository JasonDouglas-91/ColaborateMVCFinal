package com.combinationMVC.boot.exploreComputer.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.sql.Date;

@Entity
@Table(name="USERORDER")
public class UserOrder implements Serializable {
    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="USER_ID")
    private long userId;
    @Column(name="PRODUCT_ID")
    private long productId;
    @Column(name="ORDER_DATE")
    private Date date;

    public UserOrder() {
    	
    }
    
    public UserOrder(long id, long userId, long productId, Date orderDate) {
    	this.id = id;
    	this.userId = userId;
    	this.productId = productId;
    	this.date = orderDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return date;
    }

    public void setOrderDate(Date orderDate) {
        this.date = orderDate;
    }
}
