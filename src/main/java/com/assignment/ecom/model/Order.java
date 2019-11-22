package com.assignment.ecom.model;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String status;
	@Column
	private Date date;
	
	@OneToOne(optional=false)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@OneToOne(optional=false)
	@JoinColumn(name = "user_id")
	private User user;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

	

	
	
	
}
