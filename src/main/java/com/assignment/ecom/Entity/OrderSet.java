package com.assignment.ecom.Entity;

public class OrderSet {
	private Long userid;
	private Long productid;
	
	
	protected OrderSet() {
		
	}
	public OrderSet(Long userid, Long productid) {
		
		this.userid = userid;
		this.productid = productid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	
	
}
