package com.niit.shopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3934911384055536325L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int order_id;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name="shipping_id")
	private ShippingAddress shippingAddress;
	
	
}
