package com.niit.shopping.model;

import java.io.Serializable;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.shopping.service.ProductService;

@Component
public class CheckOut implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8089491851587514532L;

	
	public ShippingAddress addressFlow(){
		return new ShippingAddress();
	}
	
	
	@Autowired
	ProductService productService; 
	
	public void saveAddress(ShippingAddress shippingAddress)
	{
		
		
		productService.saveAddress(shippingAddress);
		/*session.setAttribute("cartItem", productService.getCartByUser(activeuser.getName()));*/
	}
	
	
	
	
	
}