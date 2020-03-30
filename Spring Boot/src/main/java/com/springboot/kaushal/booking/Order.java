package com.springboot.kaushal.booking;

public class Order {
	private int orderID;
	private String oderName;
	private String orderDestination;
	private String orderSource;

	public Order() {
		super();
	}

	public Order(int id, String orderName, String orderDestination, String orderSource) {
		super();
		this.orderID = id;
		this.oderName = orderName;
		this.orderDestination = orderDestination;
		this.orderSource = orderSource;
	}

	public int getId() {
		return orderID;
	}

	public void setId(int id) {
		this.orderID = id;
	}

	public String getOrderName() {
		return oderName;
	}

	public void setOrderName(String orderName) {
		this.oderName = orderName;
	}

	public String getOrderDestination() {
		return orderDestination;
	}

	public void setOrderDestination(String orderDestination) {
		this.orderDestination = orderDestination;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	
}
